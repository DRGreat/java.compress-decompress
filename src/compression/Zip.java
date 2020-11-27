package compression;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static final int BUFFER = 512;
    private static final String SUFFIX=".480";

    private  List<File> getAllFile(File dirFile,boolean info)
    {

        List<File> fileList=new ArrayList<File>();
        File[] files= dirFile.listFiles();

        for(File file:files)
        {
            if(file.isFile())
            {
                fileList.add(file);
                if(info)
                    System.out.println("add file:"+file.getName());
            }
            else
            {//目录
                if(file.listFiles().length!=0)
                {
                    fileList.addAll(getAllFile(file,info));
                }
                else
                {
                    fileList.add(file);
                    if(info)
                        System.out.println("add empty dir:"+file.getName());
                }
            }
        }
        return fileList;
    }


    private  String getRelativePath(String dirPath,File file)
    {
        File dirFile=new File(dirPath);
        String relativePath=file.getName();

        while (true)
        {
            file=file.getParentFile();
            if(file==null)
            {
                break;
            }
            else if(file.equals(dirFile))
            {
                break;
            }
            else
            {
                relativePath=file.getName()+"/"+relativePath;
            }
        }
        return relativePath;
    }

    public  void compress(String dirPath,String zipFileName,boolean info) throws IOException {

        if(!zipFileName.endsWith(SUFFIX))
        {
            System.out.println("后缀格式："+SUFFIX);
            return;
        }
        File dirFile=new File(dirPath);
        List<File> fileList= getAllFile(dirFile,info);

        byte[] buffer=new byte[BUFFER];
        ZipEntry zipEntry=null;
        int readLength=0;
        var cos=new CheckedOutputStream(new FileOutputStream(zipFileName),new CRC32());
        ZipOutputStream zos = new ZipOutputStream(cos);

        for(File file:fileList)
        {
            if(file.isFile())
            {
                zipEntry=new ZipEntry(getRelativePath(dirPath,file));
                zipEntry.setSize(file.length());
                zipEntry.setTime(file.lastModified());
                zos.putNextEntry(zipEntry);

                InputStream is=new BufferedInputStream(new FileInputStream(file));

                while ((readLength=is.read(buffer,0,BUFFER))!=-1)
                {
                    zos.write(buffer,0,readLength);
                }
                is.close();
                if(info)
                    System.out.println("file compress:"+file.getCanonicalPath());
            }
            else
            {
                zipEntry=new ZipEntry(getRelativePath(dirPath,file));
                zipEntry.setExtra(new byte[]{-1});
                zos.putNextEntry(zipEntry);
                if(info)
                    System.out.println("dir compress: " + file.getCanonicalPath()+"/");
            }
        }
        zos.close();
    }
}

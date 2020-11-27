package compression;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    private static final int BUFFER = 512;
    private static final String SUFFIX=".480";

    private File createFile(String destPath, String fileName,boolean info){

        String[] dirs = fileName.split("/");
        File file = new File(destPath);

        if (dirs.length > 1)
        {
            for (int i = 0; i < dirs.length - 1; i++)
            {
                file = new File(file, dirs[i]);
            }

            if (!file.exists())
            {
                file.mkdirs();
                if(info)
                    System.out.println("mkdirs: " + file.getAbsolutePath());
            }
            file = new File(file, dirs[dirs.length - 1]);
            return file;
        }
        else
        {
            if (!file.exists())
            {
                file.mkdirs();
                if(info)
                    System.out.println("mkdirs: " + file.getAbsolutePath());
            }
            file = new File(file, dirs[0]);
            return file;
        }

    }

    public void decompress(String zipFileName,String destPath,boolean info) throws IOException
    {
        if(!zipFileName.endsWith(SUFFIX))
        {
            System.out.println("后缀格式："+SUFFIX);
            return;
        }
        ZipInputStream zis=new ZipInputStream(new FileInputStream(zipFileName));
        ZipEntry zipEntry=null;
        byte[] buffer=new byte[BUFFER];
        int readLength=0;
        while ((zipEntry=zis.getNextEntry())!=null)
        {
            if((zipEntry.getExtra()!=null&&zipEntry.getExtra()[0]==-1)||zipEntry.isDirectory())
            {
                File file=new File(destPath+"/"+zipEntry.getName());
                if(!file.exists())
                {
                    file.mkdirs();
                    if(info)
                        System.out.println("mkdirs:"+file.getCanonicalPath());
                }
            }
            else
            {
                File file = createFile(destPath, zipEntry.getName(),info);
                if(info)
                    System.out.println("file created: " + file.getAbsolutePath());
                OutputStream os = new FileOutputStream(file);
                while ((readLength = zis.read(buffer, 0, BUFFER)) != -1)
                {
                    os.write(buffer, 0, readLength);
                }
                os.close();
                if(info)
                    System.out.println("file uncompressed: " + file.getCanonicalPath());
            }
        }

    }
}

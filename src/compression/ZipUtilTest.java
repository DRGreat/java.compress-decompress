package compression;

import java.io.File;


public class ZipUtilTest {
    public static void main(String[] args)
    {
        if(args[0].equals("-c"))
        {
            var zipfile = new File(args[1]);
            if (zipfile.exists())
            {
                ZipUtil.compress(zipfile.getPath(), zipfile.getPath());
                System.out.println("sucessfully compress the " + args[1]);
            }
            else
            {
                System.out.println("file not exists");
            }
        }
        if(args[0].equals("-d")) {
        var unzipfile=new File(args[1].substring(0,args[1].length()-4));
        if(!unzipfile.exists())
        {
            ZipUtil.decompress(unzipfile.getPath(), unzipfile.getPath());
            System.out.println("sucessfully decompress the " + args[1]);
        }
        else
        {
            System.out.println("file not exists");
        }
        }
    }
}

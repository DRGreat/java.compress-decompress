package compression;

import java.io.File;


public class ZipUtilTest {
    public static void main(String[] args)
    {
        var sourcefile=new File("D:\\java_noIDE\\xxx");
        var destfile=new File("D:\\java_noIDE\\xxx");
        if(sourcefile.exists())
        ZipUtil.compress(sourcefile.getPath(),destfile.getPath());

        var zipfile=new File("D:\\java_noIDE\\xxx");
        var unzipfile=new File("D:\\java_noIDE\\xxx");
        if(!unzipfile.exists())
        ZipUtil.decompress(zipfile.getPath(),unzipfile.getPath());
    }
}

package compression;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        var zip=new Zip();
//        zip.compress("D:\\javaFile","D:\\javaFile.480",true);
        var unzip=new UnZip();
        unzip.decompress("D:\\javaFile.480","D:\\javaFile",true);
    }
}

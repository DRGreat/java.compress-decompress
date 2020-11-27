import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Za {
    public static List<File> getAllFile(File dirFile){

        List<File> fileList=new ArrayList<>();

        File[] files= dirFile.listFiles();
        for(File file:files){//文件
            if(file.isFile()){
                fileList.add(file);
                System.out.println("add file:"+file.getName());
            }else {//目录
                if(file.listFiles().length!=0){//非空目录
                    fileList.addAll(getAllFile(file));//把递归文件加到fileList中
                }else {//空目录
                    fileList.add(file);
                    System.out.println("add empty dir:"+file.getName());
                }
            }
        }
        return fileList;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<File> list=(ArrayList<File>)getAllFile(new File("D:\\javaFile"));
        System.out.println("*******************************");
        list.forEach(e->System.out.println(e.getAbsolutePath()));
    }
}

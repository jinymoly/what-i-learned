package theStandardOfJava.part_02;

import java.io.File;
import java.io.FilenameFilter;

public class Ex15_16 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java EX15_16 DIRECTORY");
            System.exit(10);
        }

        File f = new File(args[0]);

        if(!f.exists() || !f.isDirectory()){
            System.out.println("유효하지 않은 디렉토리 입니다.");
            System.exit(0);
        }

        File[] files = f.listFiles();

    for(int i = 0; i < files.length; i++){
        String fileName = files[i].getName();
        System.out.println(files[i].isDirectory() ? "["+fileName+"]" : fileName);
    }
    }
}

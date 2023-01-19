package theStandardOfJava.part_01;

public class Ex9_4 {
    
    public static void main(String[] args) {
        System.out.println(contains("123456", "45"));
        System.out.println(contains("2345", "12"));
    }

    public static boolean contains(String src, String target){
        return src.indexOf(target) !=-1;
    }
}

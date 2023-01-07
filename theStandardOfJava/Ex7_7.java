package theStandardOfJava;

public class Ex7_7 {
    
    public static void main(String[] args) {
        Outer1.Inner1 in = new Outer1.Inner1();
        System.out.println(in.iv);
    }
}

class Outer1 {
    static class Inner1 {
        int iv = 3333;
    }
}

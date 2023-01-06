

public class Ex7_6 {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner in = o.new Inner();
        System.out.println(in.iv);
        
    }
}


class Outer {
    class Inner {
        int iv = 100;
    }
}

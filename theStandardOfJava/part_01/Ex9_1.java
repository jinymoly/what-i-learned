package theStandardOfJava.part_01;

public class Ex9_1 {
    
    public static void main(String[] args) {
        SutdaCard5 c1 = new SutdaCard5(3, true);
        SutdaCard5 c2 = new SutdaCard5(3, true);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c1.equals(c2) : " + c2.equals(c2));
    }
}

class SutdaCard5 {
    int num;
    boolean isKwang;

    SutdaCard5(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }

    SutdaCard5(){
        this(1, true);
    }

    public boolean equals(Object obj) { 
        if(obj instanceof SutdaCard5){ 
            SutdaCard5 c5 = (SutdaCard5)obj; 
            return num == c5.num && isKwang == c5.isKwang;
        }
        return false;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

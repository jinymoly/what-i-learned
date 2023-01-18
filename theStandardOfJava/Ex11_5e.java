package theStandardOfJava;

import java.util.HashSet;

public class Ex11_5e {

    public static void main(String[] args) {
        SutdaCard2 c1 = new SutdaCard2(3, true);
        SutdaCard2 c2 = new SutdaCard2(3, true);
        SutdaCard2 c3 = new SutdaCard2(1, true);

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);
       
        System.out.println(set);
    }

}

class SutdaCard2 {
    int num;
    boolean isKwang;

    SutdaCard2(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }

    SutdaCard2() {
        this(1, true);
    }

    public boolean equals(Object obj){
        if(obj instanceof SutdaCard2){
            SutdaCard2 s = (SutdaCard2)obj;
            return num == s.num && isKwang == s.isKwang;
        } else {
            return false;
        }
    }

    public String toString(){
        return num + (isKwang ? "K" : "");
    }

    public int hashCode() {
        return toString().hashCode();
    }
}

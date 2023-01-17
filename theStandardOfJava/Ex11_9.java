package theStandardOfJava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "5", "5"};
        Set set = new HashSet<>();

        for(int i = 0; i<objArr.length; i++) {
            set.add(objArr[i]);
        }

        System.out.println("set : " + set);

        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            System.out.println("next : " + iterator.next());
        }
    }
}

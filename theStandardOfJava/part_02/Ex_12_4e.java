package theStandardOfJava.part_02;

import java.util.ArrayList;

public class Ex_12_4e {
    
    public static <T extends Product>ArrayList merge(
        ArrayList<T>list, ArrayList<T> list2) {
            ArrayList<T> newList = new ArrayList<>(list);
    
            newList.addAll(list2);
    
            return newList;
}

    }



package theStandardOfJava.part_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_6e {
    public static void main(String[] args) {
        Set set = new HashSet();
        int[][] board = new int[5][5];

        for(int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random()*30) +1+ "");
        }

        ArrayList list = new ArrayList(set);
        Collections.shuffle(list);

        Iterator it = list.iterator();

            for(int i =0; i < board.length; i++) { 
                for(int j=0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String)it.next()); 
                System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
        }
        System.out.println();
     }
    }
}

package theStandardOfJava.part_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Ex11_3e {
    public static void main(String[] args) {

        ArrayList list5 = new ArrayList();
        list5.add(new Student("홍길동", 1, 1, 100, 100, 100));
        list5.add(new Student("김가가", 1, 2, 90, 70, 80));
        list5.add(new Student("이나나", 1, 3, 80, 80, 90));
        list5.add(new Student("박다다", 1, 4, 70, 90, 70));
        list5.add(new Student("최라라", 1, 5, 60, 100, 80));

        Collections.sort(list5);
        Iterator it = list5.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }    
}


class Student implements Comparable { 

    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban; 
        this.no = no; 
        this.kor = kor; 
        this.eng = eng; 
        this.math = math;
    }

    int getTotal() {
        return kor+eng+math;
    }

    float getAverage() {
     return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }

    public String toString() {
        return name +","+ban +","+no +","+kor +","+eng +","+math +","+getTotal() +","+getAverage();
    }

    public int compareTo(Object o) { 
        if(o instanceof Student) {
            Student tmp = (Student)o;

        return name.compareTo(tmp.name); // String클래스의 compareTo()를 호출 
        } else {
            return -1; 
        }
    }
}
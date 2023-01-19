package theStandardOfJava.part_02;

import java.util.*;

public class Ex11_4e {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(new Student("고구마", 2, 1, 100, 100, 100));
        list.add(new Student("김다람", 2, 2, 90, 70, 80));
        list.add(new Student("이토끼", 1, 3, 80, 80, 90));
        list.add(new Student("박코코", 1, 1, 70, 90, 70));
        list.add(new Student("유바바", 1, 2, 60, 100, 80));

        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();

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
}

class BanNoAscending implements Comparator {
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Student && o2 instanceof Student){
            Student s1 = (Student)o1;
            Student s2 = (Student)o2;

            return s1.ban == s2.ban ? s1.no - s2.no : s1.ban - s2.ban;
        }
        return -1;
    }
}
package theStandardOfJava.part_02;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Ex14_10 {
    public static void main(String[] args) {
        Student2[] stuArr = {
            new Student2("가가가", true, 1, 1, 100),
            new Student2("나가가", false, 1, 1, 350),
            new Student2("다가가", true, 1, 1, 200),
            new Student2("라가가", false, 1, 2, 150),
            new Student2("마가가", true, 1, 2, 100),
            new Student2("바가가", false, 1, 2, 50),
            new Student2("사가가", false, 1, 3, 100),
            new Student2("아가가", false, 1, 3, 150),
            new Student2("자가가", true, 1, 3, 200),
            new Student2("차가가", true, 2, 1, 240),
            new Student2("카가가", false, 2, 1, 250),
            new Student2("타가가", true, 2, 1, 200),
            new Student2("파가가", false, 2, 2, 100),
            new Student2("하가가", true, 2, 2, 150),
            new Student2("김가가", false, 2, 2, 120),
            new Student2("이가가", false, 2, 3, 100),
            new Student2("박가가", false, 2, 3, 250),
            new Student2("최가가", true, 2, 3, 130)
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr).collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for(Student2 m : maleStudent) 
            System.out.println(m);
        
        for(Student2 fm : femaleStudent )
            System.out.println(fm);
        
        
        System.out.printf("%n2. 단순 분할 + 통계(성별 학생 수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(partitioningBy(Student2::isMale, counting()));

        System.out.println("여학생 수 : " + stuNumBySex.get(false));
        System.out.println("남학생 수 : " + stuNumBySex.get(true));

        System.out.printf("%n3. 단순 분할 + 통계 ( 성별 1등)%n");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr).collect(partitioningBy(Student2::isMale, maxBy(comparingInt(Student2::getScore))));

        System.out.println("여학생 1등 : " + topScoreBySex.get(false));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                    .collect(partitioningBy(Student2::isMale, collectingAndThen(maxBy(comparingInt(Student2::getScore)), Optional::get)));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));
        System.out.println("남학생 1등 : "+ topScoreBySex2.get(true));

    }
}

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score){
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName() {
        return name;
    }

    boolean isMale() {
        return isMale;
    }

    int getHak() {
        return hak;
    }

    int getBan() {
        return ban;
    }

    int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년, %d반, %3d점]", 
                                name, isMale ? "남" : "여", hak, ban, score);
    }
    
    enum Level {
        HIGH, MID, LOW
    }
    

}
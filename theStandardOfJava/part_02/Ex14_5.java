package theStandardOfJava.part_02;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {
    public static void main(String[] args) {
        Stream<Student5> studentStream = Stream.of(
            new Student5("이지금", 3, 300),
            new Student5("박지금", 1, 200),
            new Student5("오지금", 5, 400),
            new Student5("김지금", 2, 240),
            new Student5("유지금", 3, 520),
            new Student5("소지금", 1, 130),
            new Student5("하지금", 3, 540),
            new Student5("고지금", 2, 460),
            new Student5("최지금", 4, 270)
        );

        studentStream.sorted(Comparator.comparing(Student5::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                        .forEach(System.out::println);
        
    }
}

class Student5 implements Comparable<Student5> {
    String name;
    int ban;
    int totalScore;

    Student5(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName() {
        return name;
    }

    int getBan() {
        return ban;
    }

    int getTotalScore() {
        return totalScore;
    }

    public int compareTo(Student5 o) {
        return o.totalScore - this.totalScore;
    }

}


package theStandardOfJava.part_02;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Ex14_11 {
    public static void main(String[] args) {
        Student11[] stdArr = {
            new Student11("가니니", true, 1, 1, 170),
            new Student11("나니니", false, 1, 1, 350),
            new Student11("다니니", true, 1, 1, 240),
            new Student11("라니니", false, 1, 2, 250),
            new Student11("마니니", true, 1, 2, 430),
            new Student11("바니니", false, 1, 2, 250),
            new Student11("사니니", false, 1, 3, 100),
            new Student11("아니니", false, 1, 3, 150),
            new Student11("자니니", true, 1, 3, 230),
            new Student11("차니니", true, 2, 1, 240),
            new Student11("카니니", false, 2, 1, 250),
            new Student11("타니니", true, 2, 1, 280),
            new Student11("파니니", false, 2, 2, 160),
            new Student11("하니니", true, 2, 2, 150),
            new Student11("김니니", false, 2, 2, 120),
            new Student11("이니니", false, 2, 3, 150),
            new Student11("박니니", false, 2, 3, 290),
            new Student11("최니니", true, 2, 3, 130)
        };
        System.out.printf("1. 단순 그룹화(반 별로 그룹화)%n");
        Map<Integer, List<Student11>> stdByBan = Stream.of(stdArr).collect(groupingBy(Student11::getBan));
    
        for(List<Student11> ban : stdByBan.values()){
            for(Student11 s : ban){
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그릅화(성적별로 그룹화)%n");
        Map<Student11.Level, List<Student11>> stdByLevel = Stream.of(stdArr)
                    .collect(groupingBy(s -> {
                        if(s.getScore() >= 200)
                            return Student11.Level.HIGH;
                        else if(s.getScore() >=100)
                            return Student11.Level.MID;
                        else return Student11.Level.LOW;
                    }));
        TreeSet<Student11.Level> keySet = new TreeSet<>(stdByLevel.keySet());

        for(Student11.Level key : keySet){
            System.out.println("[" + key + "]");

            for(Student11 s : stdByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순 그룹화 + 통계(성적별 학생수)%n");
        Map<Student11.Level, Long> stdCountByLevel = Stream.of(stdArr)
                        .collect(groupingBy(s -> {
                            if(s.getScore() >= 200) return Student11.Level.HIGH;
                            else if(s.getScore() >= 100) return Student11.Level.MID;
                            else return Student11.Level.LOW;
                        }, counting()));

        for(Student11.Level key : stdCountByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stdCountByLevel.get(key));
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별");
        Map<Integer, Map<Integer, List<Student11>>> stdByHakAndBan = Stream.of(stdArr)
                        .collect(groupingBy(Student11::getHak, groupingBy(Student11::getBan)));

        for(Map<Integer, List<Student11>> hak : stdByHakAndBan.values()){
            for(List<Student11> ban : hak.values()){
                    System.out.println();
                for(Student11 s : ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student11>> topStuByHakAndBan = Stream.of(stdArr)
                .collect(groupingBy(Student11::getHak, groupingBy(Student11::getBan, collectingAndThen(maxBy(comparingInt(Student11::getScore)), Optional::get))));

        for(Map<Integer, Student11> ban : topStuByHakAndBan.values())
            for(Student11 s : ban.values())
                System.out.println(s);
        
        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student11.Level>> stdByScoreGroup = Stream.of(stdArr).collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                    mapping(s -> {
                        if(s.getScore() >= 200) return Student11.Level.HIGH;
                        else if(s.getScore() >= 100) return Student11.Level.MID;
                        else return Student11.Level.LOW;

                    }, toSet())));

        Set<String> keySet2 = stdByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("[" + key + "]" + stdByScoreGroup.get(key));
        }
    }
    
}

class Student11 {
    String name;
    boolean isFemale;
    int ban;
    int hak;
    int score;

    
    
    String getName() {
        return name;
    }

    boolean isFemale() {
        return isFemale;
    }

    int getBan() {
        return ban;
    }

    int getHak() {
        return hak;
    }

    int getScore() {
        return score;
    }

    Student11(String name, boolean isFemale, int ban, int hak, int score) {
        this.name = name;
        this.isFemale = isFemale;
        this.ban = ban;
        this.hak = hak;
        this.score = score;
    }

    public String toString(){
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isFemale ? "여":"남", hak, ban, score);
    }

    enum Level {
        HIGH, MID, LOW
    }
    
}

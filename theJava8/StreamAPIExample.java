package theJava8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExample {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
        .filter(oc -> oc.getTitle().startsWith("spring"))
        .forEach(oc -> System.out.println(oc.getId()));
        System.out.println("=========================");
        
        System.out.println("close 되지 않은 수업");
        springClasses.stream()
        .filter(Predicate.not(OnlineClass::isClosed))
        .forEach(oc -> System.out.println(oc.getTitle()));
        System.out.println("=========================");
        
        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
        .map(OnlineClass::getTitle)
        .forEach(System.out::println);
        System.out.println("=========================");
        
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
        .flatMap(Collection::stream)
        .forEach(oc -> System.out.println(oc.getId()));
        System.out.println("=========================");
        
        System.out.println("10부터 3씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 3)
        .skip(10)
        .limit(10)
        .forEach(System.out::println);
        System.out.println("=========================");
        
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean includeTest = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(includeTest);
        System.out.println("=========================");
        
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> collect = springClasses.stream()
        .map(OnlineClass::getTitle)
        .filter(s -> s.contains("spring"))
        .collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("=========================");
        
        System.out.println("optional 존재 여부 확인하기");
        Optional<OnlineClass> optional = springClasses.stream().filter(oc -> oc.getTitle().startsWith("rest")).findFirst();
        boolean present = optional.isPresent();
        System.out.println(present);

        OnlineClass onlineClass = optional.get();
        System.out.println(onlineClass.getTitle());
        System.out.println("=========================");

        // 여기서부터 Optional 활용하기 
        System.out.println("if문 쓰지 않고 optional인데 값이 있으면 값의 제목을 출력 아니면..의 몇 가지 방법 ");
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        Optional<OnlineClass> optionalJpa = springClasses.stream().filter(oc -> oc.getTitle().startsWith("jpa")).findFirst();
        
        /*
         * optional은 꺼내기 전에 분기문을 걸어서 null인 경우 어케 대처할지 생각해야 함 
         * 아래는 값이 없을 때 
         *  1. orElse : 메서드를 호출(있을 때도 호출 되려면)
         *  2. orElseGet : 메서드를 호출(있으면 createNewClass() 실행 안 되게 - supplier) >> Lazy하게 다루는 법 
         *          supplier는 매개변수 X, 리턴 값 O
         *  3. orElseGet : 메서드를 호출(있으면 createNewClass() 실행 안 되게 - 근데 메서드 레퍼런스를 활용)
         *  4. orElseThrow : 없으면 예외 처리
         *  5. orElseThrow : 없으면 예외 처리 - 근데 메서드 레퍼런스 사용
         */
        OnlineClass orElse = optionalJpa.orElse(createNewClass()); // 1. 근데 이건 값이 있어도 아래 createNewClass()가 실행 됨 
        optionalJpa.orElseGet(() -> createNewClass()); // 2.
        optionalJpa.orElseGet(StreamAPIExample::createNewClass); // 3. 이건 메서드 레퍼런스를 사용한 방법
        
        optionalJpa.orElseThrow(() ->  { // 4.
            return new IllegalArgumentException();
        });
        System.out.println("=========================");


        Optional<OnlineClass> findFirst = springClasses.stream().filter(oc -> oc.getTitle().startsWith("dodo")).findFirst();
        findFirst.orElseThrow(IllegalArgumentException::new); // 5.
        System.out.println("=========================");

        
        System.out.println("close되지 않은 것(false)가 비어있나요");
        Optional<OnlineClass> closeFalse = optional.filter(OnlineClass::isClosed);
        System.out.println(closeFalse.isEmpty());
        System.out.println("=========================");

        
        System.out.println(orElse.getTitle());
        System.out.println("=========================");
        
        System.out.println("아이디가 존재 합니까");
        Optional<Integer> integer = closeFalse.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        System.out.println("=========================");
        System.out.println("Optional 2 -> 1번 벗겨내기 ");
        // Optional의 flatMap() 사용 하기 
        Optional<Progress> flatMap = findFirst.flatMap(OnlineClass::getProgress); // 1번으로 가능 

        Optional<Optional<Progress>> optionalMap = findFirst.map(OnlineClass::getProgress); // 2번 해야 함 
        Optional<Progress> progress = optionalMap.orElseThrow();
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new class");
        return new OnlineClass(10, "New JPA class", false);
    }
    
}
 
package theStandardOfJava.part_02;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class Ex12_8 {
    public static void main(String[] args) {
        Class<Ex12_8> cls = Ex12_8.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class); // 실행시간에 얻음
        System.out.println("anno.testBy() = " + anno.testBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

        for(String str : anno.testTools())
            System.out.println("testTools = " + str);
            
        System.out.println();


        Annotation[] annoArr = cls.getAnnotations();

        for(Annotation a : annoArr)
            System.out.println(a);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    int count() default 1;
	String testBy();
	String[] testTools() default "JUnut";
	TestType testType() default TestType.FIRST;
	DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType {
    FIRST, FINAL
}

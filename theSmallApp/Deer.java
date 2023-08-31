package theSmallApp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Deer {
    private static final String CATEGORY = "동물";

    private String name;
    public int age;

    private void speak(final String sound, final int count){
        System.out.println(sound.repeat(count));
    }

    public void eats(){
        System.out.println("풀을 뜯어 먹다.");
    }

    public int getAge() {
        return age;
    }

    private Deer() {
        this.name = "밤비";
        this.age = 0;
    }

    public Deer(String name) {
        this.name = name;
    }

    public Deer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("theSmallApp.Deer");

        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);

        Object deer = constructor.newInstance("백두산사슴", 300);

        Field field = clazz.getDeclaredField("name");

        field.setAccessible(true);
        System.out.println("기존 : " + field.get(deer));
        field.set(deer, "순록");
        System.out.println("변경 : " + field.get(deer));

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            method.setAccessible(true);
            System.out.println(method);
            System.out.println("\n----------------------");
        }

        Method method = clazz.getDeclaredMethod("speak", String.class, int.class);
        method.setAccessible(true);
        method.invoke(deer, "먀아아아아아~ ", 5);
    }
}
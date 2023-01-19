package theStandardOfJava.part_02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ex11_11 {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add("asd");
        set.add("asd");
        set.add(new Person("David",10));
        set.add(new Person("David",10));

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " : " + age;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) return false;
        Person p = (Person)obj;
        return name.equals(p.name) && age == p.age;
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }
}
package theStandardOfJava.part_02;

import java.util.ArrayList;

public class Ex12_3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Peach> peachBox = new FruitBox<Peach>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Peach());
        appleBox.add(new Apple());
        peachBox.add(new Peach());
    
        
        System.out.println("fruitBox - " + fruitBox);
        System.out.println("appleBox - " + appleBox);
        System.out.println("peachBox - " + peachBox);
        
    }
}


class Fruit implements Eatable {
    public String toString() {return "Fruit";}
}

class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}

class Peach extends Fruit {
    public String toString() {
        return "Peach";
    }
}

class Toy {
    public String toString() {
        return "Toy";
    }
}

interface Eatable {}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();

    void add(T item) {
        list.add(item);
    }
    T get(int i) {
        return list.get(i);
    }
    int size() {
        return list.size();
    }
    public String toString(){
        return list.toString();
    }
}

package theStandardOfJava.part_02;

import java.util.ArrayList;

public class Ex12_4 {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox2 = new FruitBox2<Fruit2>();
        FruitBox2<Banana> bananaBox2 = new FruitBox2<Banana>();

        fruitBox2.add(new Banana());
        fruitBox2.add(new Lemon());
        bananaBox2.add(new Banana());
        bananaBox2.add(new Banana());

        System.out.println(Juicer.makeJuice(bananaBox2));
        System.out.println(Juicer.makeJuice(fruitBox2));
    }
}

class Fruit2 {
    public String toString(){
        return "Fruit2";
    }
}
class Banana extends Fruit2 {
    public String toString(){
        return "Banana";
    }
}
class Lemon extends Fruit2 {
    public String toString() {
        return "Lemon";
    }
}

class Juice {
    String name;

    Juice (String name){
        this.name = name + "Juice";
    }

    public String toString(){
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box){
        String tmp = "";

        for(Fruit2 f : box.getList())
            tmp += f + " ";
            return new Juice(tmp);

    }
}

class FruitBox2<T extends Fruit2> extends Box2<T> {}

class Box2<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item){
        list.add(item);
    }
    T get(int i){
        return list.get(i);
    }
    ArrayList<T> getList() {
        return list;
    }
    int size(){
        return list.size();
    }
    public String toString(){
        return list.toString();
    }
    
}

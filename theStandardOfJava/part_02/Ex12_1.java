package theStandardOfJava.part_02;

import java.util.ArrayList;
import java.util.List;

public class Ex12_1 {
    
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv> tvList = new ArrayList<Tv>();
        // ArrayList<Product> tvList2 = new ArrayList<Tv>(); -- 에러 
        List<Tv> tvList3 = new ArrayList<Tv>(); // 지네릭 타입이 아닌 클래스 타입 간의 다형성 - 가능 

        productList.add(new Tv());
        productList.add(new Audio());

        tvList.add(new Tv());
        tvList.add(new Tv());

        printAll(productList);
    }

    public static void printAll(ArrayList<Product> list) {
        for(Product p : list)
        System.out.println(p);
    }
}

class Product {}
class Tv extends Product{}
class Audio extends Product{}


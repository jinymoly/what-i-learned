package theStandardOfJava.part_01;

import theStandardOfJava.part_02.Audio;
import theStandardOfJava.part_02.Product;

public class Ex7_28 {
    
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Computer("apple"));
        buyer.buy(new Tv1("yello", "star"));
        buyer.buy(new Audio());
        buyer.summery();

        System.out.println("현재 잔액은 "+buyer.money + "만원 입니다.");
        System.out.println("현재 적립된 포인트는 " + buyer.bonusPoint + "점 입니다.");
    }
}

    class Product {
        int price;
        int bonusPrice;
        int totalprice;

        Product(int price){
            this.price = price;
            bonusPrice = (int)(price/1.0);
        }
    }

    class Tv1 extends Product {
        String color;
        String shape;

        Tv1(String color, String shape) {
            super(100);
            this.color = color;
            this.shape = shape;
        }

        public String toString() {
            return color+"색이며 "+ shape +"형 Tv" ;
        }
    }

    class Computer extends Product {
        String brand;

        Computer(String brand) {
            super(200);
            this.brand = brand;
        }

        public String toString() {
            return brand + "사의 Computer ";
        }
    }

    class Audio extends Product {
        Audio(){
            super(50);
        }

        public String toString() {
            return "Audio";
        }
    }

    class Buyer {
        int money = 1000;
        int bonusPoint = 0;
        Product[] cart = new Product[5];
        int i = 0;

        void buy(Product p){
            if(money < p.price){
                System.out.println("잔액이 부족하여 물건을 구매할 수 없다.");
            return;
            }
        money -= p.price;
        bonusPoint += p.bonusPrice;
        cart[i++] = p;
        System.out.println(">> "+p + " << 를 구입하셨군요.");
        }

        void summery(){
            int sum = 0;
            String pList = "";

            for(int i = 0; i<cart.length; i++){
                 if(cart[i]==null) 
                 break;
                 sum += cart[i].price;
                 pList += (i==0) ? "" + cart[i] : "," + cart[i];

                }
                System.out.println("지금까지 구입하신 물건의 가격은 총 " + sum + "입니다.");
                System.out.println("지금까지 구입하신 물건은 " + pList + "입니다.");
                
        }

        
        
    }

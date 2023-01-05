public class Ex7_28 {
    
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Computer("apple"));
        buyer.buy(new Tv1("yello", "star"));
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

    class Buyer {
        int money = 1000;
        int bonusPoint = 0;

        void buy(Product p){
            if(money < p.price){
                System.out.println("잔액이 부족하여 물건을 구매할 수 없다.");
            return;
        }

        money -=p.price;
        bonusPoint +=p.bonusPrice;
        System.out.println(">> "+p + " << 를 구입하셨군요.");
    }
}

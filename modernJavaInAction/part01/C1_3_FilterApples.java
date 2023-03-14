package modernJavaInAction.part01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class C1_3_FilterApples {

  public static void main(String[] args) {
    
  }

  public static List<Apple> filterHeavyApples(List<Apple> inventory){

    List<Apple> result = new ArrayList<>();

    for(Apple apple : inventory){
      if(apple.getWeight() > 150){
        result.add(apple);
      }
    } return result;
  }

  public static boolean isGreenApple(Apple apple){
    return "green".equals(apple.getColor());
  }

  public static boolean isHeavyApple(Apple apple){
    return apple.getWeight() > 150;
  }

  public List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
    List<Apple> result = new ArrayList<>();
    for(Apple apple : inventory){
      if(p.test(apple)){
        result.add(apple);
      }
    }
    return result;
  }

public static class Apple {

    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
      this.weight = weight;
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
      return String.format("Apple{color='%s', weight=%d}", color, weight);
    }

  }
}

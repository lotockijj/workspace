package JavaRush;
/* –еализовать метод addPrice
–еализовать метод addPrice(int applesPrice), чтобы при его вызове суммарна€ стоимость €блок увеличивалось на переданное значение.
«а суммарную стоимость €блок отвечает переменна€ public static int applesPrice.
*/
public class Solution111{
    public static void main(String[] args) {
        Apple apple = new Apple();
        Apple.addPrice(50);
        Apple apple2 = new Apple();
        Apple.addPrice(100);
        System.out.println("Apples price is " + Apple.applesPrice);
    }

    public static class Apple{
        public static int applesPrice = 0;

        public static void addPrice(int applesPrice){
        	Apple.applesPrice = Apple.applesPrice + applesPrice;
           // System.out.println("The Apples price is() " + Apple.applesPrice);
        }
    }
}


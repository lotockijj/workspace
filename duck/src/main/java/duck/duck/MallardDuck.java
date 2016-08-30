package duck.duck;

/**
 * Created by ����� ��������� on 07.08.2016.
 */
public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("I'm real Mallard duck... ");
    }
}

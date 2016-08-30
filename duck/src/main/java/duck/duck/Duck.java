package duck.duck;

/**
 * Created by ����� ��������� on 07.08.2016.
 */
public abstract class Duck {
	
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){
    }
    
    public void setFlyBehavior(FlyBehavior fb){
    	flyBehavior = fb;
    }
    
    public void setQuackBehavior(QuackBehavior qb){
    	quackBehavior = qb;
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("All duck float, even decoys!");
    }
}

package Duck;

public class MalarDuck extends Duck{
	public MalarDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
		}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		//System.out.println(�I�m a real Mallard duck�);
	}

}

package patterns.of.patterns;

public class GeeseFactory extends AbstractGeeseFactory{

	@Override
	public Quackable createGoose() {
		return new GooseAdapter(new Goose());
	}

}

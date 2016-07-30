package Game.java_courses;

public class Calculator{
	
	private int result;

	public void add(int... params){
		for(Integer param : params){
			this.result +=param;
		}
	}	
	
	/**
	 *   Вичисляєм ділення.
	 * @param args Вхідні параметри. 
	 * @throws UserException Якщо аргументів нема, викидуємо виключення... 
	 */
	public void div(int... args) throws UserException{
		if(args.length > 0){
			this.result = args[0];
			for(int params : args){
				if(params == 0) 
					throw new IllegalArgumentException("You try to devide 0. Please change args");
				this.result /= result;
			}
		} else{
			throw new UserException("You should enter args");
		}
	}
	
	public int getResult(){
		return this.result;
	}

	public void clearResult(){
		this.result = 0;
	}
}
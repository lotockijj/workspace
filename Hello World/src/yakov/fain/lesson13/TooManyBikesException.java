package yakov.fain.lesson13;

public class TooManyBikesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TooManyBikesException (String msgText){
		super(msgText);
	}
}

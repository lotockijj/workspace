package efective.java.person.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack <E>{

	private E[] elements;
	private int size;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	// The elements array will contain only E instances from push(E).
	// This is sufficient to ensure type safety, but the runtime
	// type of the array won't be E[]; it will always be Object[]!
	@SuppressWarnings("unchecked")
	public Stack(){
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	public E pop() {
		if (size==0) {
			throw new EmptyStackException();
		}
		E result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (String arg : args)
			stack.push(arg);
		while (!stack.isEmpty())
			System.out.println(stack.pop().toUpperCase());
	}

	private boolean isEmpty() {
		if(size == 0){
			return true; 
		}
		return false;
	}

}

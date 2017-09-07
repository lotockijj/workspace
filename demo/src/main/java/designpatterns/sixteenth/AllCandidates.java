package designpatterns.sixteenth;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class AllCandidates implements Iterator<Candidate>{
	private Vector<Candidate> data;
	Enumeration<Candidate> ec;
	Candidate nextCandidate;
	
	public AllCandidates(){
		initialize();
		ec = data.elements();
	}
	
	@Override
	public boolean hasNext() {
		//boolean matchFound = false;
		nextCandidate = null;
		while(ec.hasMoreElements()){
			Candidate tempCand = ec.nextElement();
			nextCandidate = tempCand;
			break;
		}
		return (nextCandidate != null);
	}

	@Override
	public Candidate next() {
		if(nextCandidate == null){
			throw new NoSuchElementException();
		} else {
			return nextCandidate;
		}
	}

	private void initialize() {
		data = new Vector<>();
		data.add(new Candidate("Roman", 35, 2, "freelance"));
		data.add(new Candidate("Vitalik", 21, 0, "student"));
		data.add(new Candidate("Kolya", 36, 18, "worker"));
	}

}

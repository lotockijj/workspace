package designpatterns.sixteenth;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class CertificatedCandidates implements Iterator<Candidate>{
	private Vector<Candidate> v;
	AllCandidates2 ac;
	String certificationType;
	Candidate nextCandidate;
	Enumeration<Candidate> ec;
	
	public CertificatedCandidates(AllCandidates2 inp_ac, String type){
		ac = inp_ac;
		certificationType = type;
		ec = inp_ac.getAllCandidates();
	}
	
	@Override
	public boolean hasNext() {
		boolean matchFound = false;
		while(ec.hasMoreElements()){
			Candidate tempCand = ec.nextElement();
			if(tempCand.getType().equals(certificationType)){
				matchFound = true;
				nextCandidate = tempCand;
				break;
			}
		}
		if(matchFound == true){
		} else {
			nextCandidate = null;
		}
		return matchFound;
	}

	@Override
	public Candidate next() {
		if(nextCandidate == null){
			throw new NoSuchElementException();
		} else {
			return nextCandidate;
		}
	}
	
	public void remove(){
		
	}

}

package designpatterns.sixteenth;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class AllCandidates2 {
	private Vector<Candidate> data;

	public AllCandidates2() {
		initialize();
	}
	
	public Enumeration<Candidate> getAllCandidates() {
		return data.elements();
	}
	public Iterator<Candidate> getCertifiedCandidates(String type) {
		return new CertificatedCandidates(this, type);
	}
	
	private void initialize() {
		data = new Vector<>();
		data.add(new Candidate("Roman", 35, 2, "freelance"));
		data.add(new Candidate("Vitalik", 21, 0, "student"));
		data.add(new Candidate("Kolya", 36, 18, "worker"));
	}

}

package designpatterns.sixteenth;

import org.junit.Test;

public class AllCandidates2Test {

	@Test
	public void test() {
		AllCandidates2 allCand = new AllCandidates2();
		CertificatedCandidates candFreelance = new CertificatedCandidates(allCand, "freelance");
		while(candFreelance.hasNext()){
			System.out.println(candFreelance.next());
		}
		CertificatedCandidates candStudent = new CertificatedCandidates(allCand, "student");
		while(candStudent.hasNext()){
			System.out.println(candStudent.next());
		}
		CertificatedCandidates candWorker = new CertificatedCandidates(allCand, "worker");
		while(candWorker.hasNext()){
			System.out.println(candWorker.next());
		}
		

	}

}

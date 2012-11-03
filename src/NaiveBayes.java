
public class NaiveBayes extends Classifier {
	
	public double phraseProbability (String str, String status) {
		
		double prob = 1;
		
		String [] arr = str.split("[^a-zA-Z0-9]");
		for (String s: arr) {
			s = s.toLowerCase();
			
			prob *= this.weightedProbability(s, status);
		}
		
		return prob;
	}
	
	public double probability (String str, String status) {
		
		return this.countStatus(status)/this.countTotal()*this.phraseProbability(str, status);
	}

}

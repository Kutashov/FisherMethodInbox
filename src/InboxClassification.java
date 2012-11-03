
public class InboxClassification {

	
	public static void main(String[] args) {
		
		NaiveBayes classifier = new NaiveBayes();
		
		
		classifier.train("Nobody owns the water", "work");
		classifier.train("the quick rabbit jumps fences", "work");
		classifier.train("buy pharmaceuticals now", "personal");
		classifier.train("make quick money at the online casino", "personal");
		classifier.train("the quick brown fox jumps", "work");
		
		System.out.println(classifier.toString());
		
		System.out.println(classifier.probability("quick rabbit", "work"));
		System.out.println(classifier.probability("quick rabbit", "personal"));
		
	
	}

}

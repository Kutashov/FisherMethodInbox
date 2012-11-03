import java.util.ArrayList;
import java.util.List;




public class Classifier {

	
	private List<Cell> features = new ArrayList<Cell>();
	private Categories categories = new Categories();
	
	Classifier () {
	}
	
	public void train(String str, String status) {
		if (!status.equals("personal") && !status.equals("work") && !status.equals("entertainment") && !status.equals("other")) {
			System.out.println("Unexpected statusus is entered");
			return;
		}
		String [] arr = str.split("[^a-zA-Z0-9]");
		for (String s: arr) {
			s = s.toLowerCase();
			
			if (s.length() > 1) {
				if (this.contains(s)) {
					this.incFeatureVal(s, status);
				} else {
					Cell cell = new Cell(s);
					
					for (Feature feat: cell.categories.status) {
						if (feat.name.equals(status)){
							++feat.value;
						}
					}
					
					this.features.add(cell);
				}
			}
		}
		
		this.incCategoryVal(status);
	}
	
	public String toString () {
		
		if (this.features.isEmpty())
			return "List is empty";
		
		System.out.println("Classifier is working with features:");
		
		for (Cell cell: this.features) {
			System.out.println(cell.toString());
		}
		
		System.out.println("Results by categories: ");
		return categories.toString();
	}
	
	public void incFeatureVal (String str, String status) {
	
		for (Cell cell: this.features) {
			if (cell.name.equals(str)) {
				for (Feature feat: cell.categories.status) {
					if (feat.name.equals(status)){
						++feat.value;
					}
				}
			}
		}
		
		return;
	}
	
	public void incCategoryVal (String status) {
		
		for (Feature feat: categories.status) {
			if (feat.name.equals(status))
				++feat.value;
		}
		
		return;
	}
	
	boolean contains (String str) {
		
		if (this.features.isEmpty())
			return false;
		
		for (Cell cell: this.features) {
			if (cell.name.equals(str)) 
				return true;
		}
		
		return false;
	}
	
	public double countFeature (String word, String status) {
		
		word = word.toLowerCase();
		for (Cell cell: this.features) {
			if (cell.name.equals(word)) {
				for (Feature feat: cell.categories.status) {
					if (feat.name.equals(status)) 
						return feat.value;
				}
			}
		}
		return 0;
	}
	
	public double countSamples (String word) {
		
		int sum = 0;

		for (Cell cell: this.features) {
			if (cell.name.equals(word)) {
				for (Feature feat: cell.categories.status) {
					sum += feat.value;
				}
			}
		}
		
		return sum;
	}
	
	public double countStatus (String status) {
		
		for (Feature feat: this.categories.status) {
			if (feat.name.equals(status)) {
				return feat.value;
			}
		}
			
		return 0;
	}
	
	public double countTotal () {
		
		int sum = 0;
		
		for (Feature feat: this.categories.status) {
			sum += feat.value;
		}
		
		return sum;
	}
	
	public double conditionalProbability (String word, String status) {
		
		if (this.countSamples(word) == 0)
			return 0;
		else
			return this.countFeature(word, status)/this.countStatus(status);
	}
	
	public double weightedProbability (String word, String status) {
		
		double weight = 1.0, ap = 0.5;
		
		return (weight*ap + this.countSamples(word)*this.conditionalProbability(word, status))/(weight+this.countSamples(word));
	}
}


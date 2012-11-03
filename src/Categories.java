import java.util.ArrayList;
import java.util.List;


public class Categories {

	public List<Feature> status = new ArrayList<Feature>();
	
	Categories () {
		
		status.add(new Feature("personal", 0));
		status.add(new Feature("work", 0));
		status.add(new Feature("entertainment", 0));
		status.add(new Feature("other", 0));
	}
	
	public String toString() {
		
		for (Feature feat: status) {
			System.out.print(feat.toString());
		}
		
		return "";
		
	}
}

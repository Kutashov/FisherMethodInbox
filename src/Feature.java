import java.util.Iterator;



public class Feature implements Iterable<Feature> {

	public String name;
	public Integer value;
	
	Feature (String str, Integer val) {
		
		this.name = str;
		this.value = val;
	}
	
	public String toString () {
		
		return this.name + " - " + this.value + ", ";
	}

	@Override
	public Iterator <Feature> iterator() {
		Iterator <Feature> it = iterator();
		return it;
	}
}


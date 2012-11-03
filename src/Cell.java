import java.util.Iterator;


public class Cell implements Iterable<Cell> {

		public String name;
		public Categories categories;
		
		Cell (String str) {
			
			this.name = str;
			this.categories = new Categories();
		}
		
		public String toString () {
			
			System.out.print("\"" + name + "\" : ");
			
			for (Feature feat: categories.status)
				System.out.print(feat.toString());
					
			return "";
		}

		@Override
		public Iterator <Cell> iterator() {
			Iterator <Cell> it = iterator();
			return it;
		}
	}

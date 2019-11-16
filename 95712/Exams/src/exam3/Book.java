// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book>{
	String title;
	List<String> authors;
	
	public Book(String title) {
		this.title = title;
		authors = new ArrayList<>();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Book b = (Book)obj;
		return this.title.equals(b.title);
	}

	@Override
	public int compareTo(Book b) {
		return this.title.compareTo(b.title);
	}
	
	
}

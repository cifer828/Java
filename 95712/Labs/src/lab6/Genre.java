// Qiuchen Zhang
// AndrewID: qiuchenz

package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Genre implements Comparable<Genre>{
	String genreName;
	List<Movie> genreMovies;
	
	public Genre(String genreName) {
		// TODO Auto-generated constructor stub
		this.genreName = genreName;
		genreMovies = new ArrayList<>();
	}

	@Override
	public int compareTo(Genre g) {
		// TODO Auto-generated method stub
		return g.genreMovies.size() - this.genreMovies.size();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(genreName);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Genre g = (Genre)obj;
		return this.genreName.equals(g.genreName);
	}
	
}

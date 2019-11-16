// Qiuchen Zhang
// AndrewID: qiuchenz

package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie implements Comparable<Movie>{
	String movieName;
	String movieYear;
	List<String> movieGenres;
	public Movie(String movieName, String movieYear) {
		// TODO Auto-generated constructor stub
		this.movieName = movieName;
		this.movieYear = movieYear;
		movieGenres = new ArrayList<>();
	}
	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		return this.movieName.compareTo(m.movieName);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(movieName, movieYear);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Movie m = (Movie)obj;
		return movieName.equalsIgnoreCase(m.movieName) && movieYear.equalsIgnoreCase(m.movieYear);
	}
}

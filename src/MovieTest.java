import java.util.*;

public class MovieTest{

	public static void main(String args[]){
		MovieTest   test = new MovieTest();
		Movie       m    = new Movie(1,2.3f);
		ArrayList<Movie> lst  = new ArrayList<Movie>();

		Movie m2 = new Movie(2,3.6f);
		Movie m3 = new Movie(3,2.4f);
		Movie m4 = new Movie(4,4.8f);
		lst.add(m2);
		lst.add(m3);
		lst.add(m4);
		int n = 4;
		m.setSimilarMovie(lst);


		Collections.sort(m.getSimilarMovie(), new RatingComparator());
//System.out.println(m.getSimilarMovie());
		int size = m.getSimilarMovie().size();
		List<Movie> mLst = (n < size) ? m.getSimilarMovie().subList(0,n) : m.getSimilarMovie();
		for(Movie temp: mLst){
			System.out.println(temp.getRating());
		}
	}

	}
class NewRatingComparator implements Comparator<Movie>{

	public int compare(Movie m1,Movie m2){
		if(m1.getRating() == m2.getRating()){
			return 0;
		}
		else if(m1.getRating() < m2.getRating()){
			return 1;
		}
		else
		{
			return -1;
		}
	}
}

class RatingComparator implements Comparator<Movie>{
	public int compare(Movie m1, Movie m2){
		if (m1.getRating() == m2.getRating())
			return 0;
		else if(m1.getRating() < m2.getRating())
			return 1;
		else
			return -1;
	}
}

 class Movie {

	private int movieId;
	private float            rating;
	private ArrayList<Movie> similarMovie;

	 public Movie(int movieId, float rating) {
		 this.movieId = movieId;
		 this.rating = rating;
	 }


	 public ArrayList<Movie> getSimilarMovie() {
		return similarMovie;
	}

	public void setSimilarMovie(ArrayList<Movie> similarMovie) {
		this.similarMovie = similarMovie;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}


}

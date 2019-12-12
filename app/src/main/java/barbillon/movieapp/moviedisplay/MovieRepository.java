package barbillon.movieapp.moviedisplay;

import barbillon.movieapp.api.model.MovieResponse;
import io.reactivex.Single;

public interface MovieRepository {
    Single<MovieResponse> getMovies();
}

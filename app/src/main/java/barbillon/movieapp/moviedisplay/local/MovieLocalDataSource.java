package barbillon.movieapp.moviedisplay.local;


import java.util.List;

import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.api.model.MovieViewModel;
import barbillon.movieapp.db.MovieDatabase;
import io.reactivex.Completable;
import io.reactivex.Single;

public class MovieLocalDataSource {
    private MovieDatabase movieDatabase;

    public MovieLocalDataSource(MovieDatabase movieDatabase){
        this.movieDatabase = movieDatabase;
    }

    public Single<MovieResponse> getLocalMovies(){
        return this.movieDatabase.movieDao().getMovies();
    }

    public Completable addMovies(MovieResponse movies){
        return this.movieDatabase.movieDao().addMovie(movies);
    }

    public Completable deleteMovies(){
        return this.movieDatabase.movieDao().deleteAllMovies();
    }
}

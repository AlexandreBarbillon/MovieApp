package barbillon.movieapp.moviedisplay.remote;

import barbillon.movieapp.api.MovieService;
import barbillon.movieapp.api.config.ApiConfig;
import barbillon.movieapp.api.config.ApiKey;
import barbillon.movieapp.api.config.enums.Languages;
import barbillon.movieapp.api.model.MovieResponse;
import io.reactivex.Single;

/**
 * Permet d'appeler les fonctions de MovieService
 */
public class MovieRemoteDataSource {

    private MovieService movieService;

    public MovieRemoteDataSource(MovieService movieService){
        this.movieService = movieService;
    }

    public Single<MovieResponse> getMovies(){
        return movieService.getMovieOnTheater(ApiKey.getApiKey(), ApiConfig.LANGUAGE.getValue());
    }
}

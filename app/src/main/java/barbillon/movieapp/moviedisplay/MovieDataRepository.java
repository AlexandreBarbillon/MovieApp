package barbillon.movieapp.moviedisplay;

import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.di.TempDependencyInjector;
import barbillon.movieapp.moviedisplay.remote.MovieRemoteDataSource;
import io.reactivex.Single;

public class MovieDataRepository implements MovieRepository {

    //private MovieLocalDataSource movieLocalDataSource;
    private MovieRemoteDataSource movieRemoteDataSource;
    //private MovieEntityMapper movieToMovieEntityMapper;

    /**
     * Cette classe est censée choisir entre aller chercher les données depuis internet ou depuis la base locale, une tentative a été faite sur une autre branche du projet
     */
    public MovieDataRepository(){
        this.movieRemoteDataSource = new MovieRemoteDataSource(TempDependencyInjector.getMovieDisplayService());
    }

    @Override
    public Single<MovieResponse> getMovies() {
        return this.movieRemoteDataSource.getMovies();
    }
}

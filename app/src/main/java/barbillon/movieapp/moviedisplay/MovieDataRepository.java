package barbillon.movieapp.moviedisplay;

import barbillon.movieapp.api.MovieService;
import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.di.TempDependencyInjector;
import barbillon.movieapp.moviedisplay.remote.MovieRemoteDataSource;
import io.reactivex.Single;

public class MovieDataRepository implements MovieRepository {

    //private MovieLocalDataSource movieLocalDataSource;
    private MovieRemoteDataSource movieRemoteDataSource;
    //private MovieEntityMapper movieToMovieEntityMapper;

    public MovieDataRepository(){
        this.movieRemoteDataSource = new MovieRemoteDataSource(TempDependencyInjector.getBookDisplayService());
    }

    @Override
    public Single<MovieResponse> getMovies() {
        return this.movieRemoteDataSource.getMovies();
    }
}

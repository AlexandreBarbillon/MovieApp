package barbillon.movieapp.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.api.model.MovieViewModel;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MovieDao {

    @Query("SELECT * from movieresponse")
    Single<MovieResponse> getMovies();

    @Insert
    Completable addMovie(MovieResponse movie);

    @Query("DELETE FROM movieresponse")
    Completable deleteAllMovies();

}

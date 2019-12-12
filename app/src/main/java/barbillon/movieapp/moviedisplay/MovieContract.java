package barbillon.movieapp.moviedisplay;

import java.util.List;

import barbillon.movieapp.api.model.MovieViewModel;
import io.reactivex.disposables.CompositeDisposable;

public interface MovieContract {

    void displayMovies();
}

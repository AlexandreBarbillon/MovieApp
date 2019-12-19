package barbillon.movieapp.moviedisplay;

import java.util.List;

import barbillon.movieapp.api.model.MovieViewModel;

/**
 * Le contrat avec la vue
 */
public interface ViewContract {
    void displayMovies(List<MovieViewModel> movieViewModelList);
}

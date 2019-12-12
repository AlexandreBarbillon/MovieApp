package barbillon.movieapp.api.model;

import androidx.annotation.NonNull;

import java.util.List;

public class MovieResponse {

    int pages;

    List<MovieViewModel> results;

    public MovieResponse(int pages, List<MovieViewModel> results) {
        this.pages = pages;
        this.results = results;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<MovieViewModel> getResults() {
        return results;
    }

    public void setResults(List<MovieViewModel> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(this.results.size());
    }
}

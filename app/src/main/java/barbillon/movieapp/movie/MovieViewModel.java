package barbillon.movieapp.movie;

import androidx.annotation.NonNull;

public class MovieViewModel {
    private String title;
    private String release_date;

    public MovieViewModel(String title, String release_date, String director, String description){
        this.title = title;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}

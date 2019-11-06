package barbillon.movieapp;

public class MovieViewModel {
    private final String IMG_LINK = "image.tmdb.org/t/p/w500";

    private String title;
    private String release_date;
    private String poster_path;

    public MovieViewModel(String title, String release_date, String poster_path) {
        this.title = title;
        this.release_date = release_date;
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getPoster_path() {
        return IMG_LINK+ poster_path;
    }

}

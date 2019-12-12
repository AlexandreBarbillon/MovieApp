package barbillon.movieapp.api.model;


public class MovieViewModel {
    private final String IMG_LINK = "http://image.tmdb.org/t/p/w500";

    private String title;
    private String release_date;
    private String poster_path;
    private String overview;

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

    public String getOverview() {
        return overview;
    }

    @Override
    public String toString(){
        String value = this.getTitle()+"\n";
        value+=this.getRelease_date()+"\n";
        value+=this.getOverview()+"\n";
        return value;
    }
}
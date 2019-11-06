package barbillon.movieapp.api.config;

import barbillon.movieapp.api.ApiKey;
import barbillon.movieapp.api.config.enums.Languages;

public class ApiConfig {
    public static Languages LANGUAGE = Languages.FRENCH;
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = ApiKey.getApiKey();

    public void changeLanguage(Languages lang){
        LANGUAGE = lang;
    }
}

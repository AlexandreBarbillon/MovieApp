package barbillon.movieapp.api.config;

import barbillon.movieapp.api.config.enums.Languages;

/**
 * ApiConfig est un configurateur pour l'api, elle contient la langue de base de l'API, l'url de l'API et permet de récupérer la clé d'Api de l'objet ApiKey (qui n'est pas sur le dépot git)
 */
public class ApiConfig {
    public static Languages LANGUAGE = Languages.FRENCH;
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = ApiKey.getApiKey();

    public void changeLanguage(Languages lang){
        LANGUAGE = lang;
    }
}

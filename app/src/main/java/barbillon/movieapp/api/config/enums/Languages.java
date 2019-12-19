package barbillon.movieapp.api.config.enums;

public enum Languages implements ValuedEnum {
    FRENCH("fr-FR"),
    ENGLISH("en-US");

    private String lang;

    Languages(String lang){
        this.lang = lang;
    }

    public String getValue(){
        return this.lang;
    }
}

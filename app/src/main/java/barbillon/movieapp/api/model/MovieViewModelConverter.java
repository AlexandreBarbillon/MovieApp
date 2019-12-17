package barbillon.movieapp.api.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieViewModelConverter {
    @TypeConverter
    public static List<MovieViewModel> jsonToMovie(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<MovieViewModel>>(){}.getType();
        return gson.fromJson(json, listType);
    }

    @TypeConverter
    public static String movieToJson(List<MovieViewModel> movies) {
        Gson gson = new Gson();
        return gson.toJson(movies);
    }
}

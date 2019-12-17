package barbillon.movieapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.api.model.MovieViewModelConverter;

@Database(entities = MovieResponse.class, version = 3, exportSchema = false)
@TypeConverters({MovieViewModelConverter.class})
public abstract class MovieDatabase extends RoomDatabase {
    private static MovieDatabase movieDatabase;

    public abstract MovieDao movieDao();

    public static MovieDatabase getInstance(Context context){
        if (movieDatabase == null) {
            movieDatabase = Room.databaseBuilder(context,
                    MovieDatabase.class, "book-database").build();
        }
        return movieDatabase;
    }
}

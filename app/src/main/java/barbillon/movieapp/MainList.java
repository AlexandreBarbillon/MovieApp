package barbillon.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainList extends AppCompatActivity {

    private RecyclerView movieList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter movieListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        movieList = findViewById(R.id.mainList);
        movieList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        movieList.setLayoutManager(layoutManager);
        movieListAdapter = new MovieListAdapter();
    }
}

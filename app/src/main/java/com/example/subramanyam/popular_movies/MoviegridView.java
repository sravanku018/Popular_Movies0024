package com.example.subramanyam.popular_movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MoviegridView extends AppCompatActivity {
    GridView gridView;
    ImageView imageView;
    static public ImageAdapter imageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviegrid_view);
        imageView = (ImageView) findViewById(R.id.movieImages);
        imageAdapter = new ImageAdapter(this);


        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(imageAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this, "network connected", Toast.LENGTH_SHORT).show();
        Netwrok netwrok = new Netwrok();

        if (item.getItemId() == R.id.popular)


        {
            netwrok.execute("http://api.themoviedb.org/3/movie/popular?api_key=");

        } else {
            netwrok.execute("http://api.themoviedb.org/3/movie/top_rated?api_key=");

        }

        Intent intent = new Intent(this, MoviegridView.class);
        startActivity(intent);

        return true;
    }


   @Override
    public void onBackPressed() {

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);

        startActivity(startMain);


    }

}
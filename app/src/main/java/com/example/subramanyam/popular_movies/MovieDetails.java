package com.example.subramanyam.popular_movies;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends Activity {
    ImageView imageView;
    public static MovieData movie1;


    static public TextView title, over_view, release_date, rating;
    Context context;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        title = (TextView) findViewById(R.id.movieTitle);
        over_view = (TextView) findViewById(R.id.overView);
        release_date = (TextView) findViewById(R.id.releaseDate);
        rating = (TextView) findViewById(R.id.userRating);



        imageView = (ImageView) findViewById(R.id.movieName);
        //ArrayList<String>  moviepos = (ArrayList<String>) getIntent().getExtras("image_id",MainActivity.movieUrl.size());
        int movie_id = (Integer) getIntent().getIntExtra("id", pos);







        Picasso.with(getApplicationContext()).load(MainActivity.movieUrl.get(movie_id)).fit().into(imageView);
        title.setText(MainActivity.images.get(movie_id).getOrginal_title());
        release_date.setText(MainActivity.images.get(movie_id).getRelease_date());
     rating.setText(String.valueOf(MainActivity.images.get(movie_id).getVote_average()) );
        over_view.setText(MainActivity.images.get(movie_id).getOverview());




    }


}
package com.example.subramanyam.popular_movies;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    static class ViewHolder
    {
        ImageView imageView;
        TextView title;
        TextView over_view;
        TextView release_date;
        TextView rating;
    }


    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return MainActivity.images.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
          final ImageView imageView;


        if (convertView == null) {




            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(10, 10, 10, 10);


                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Intent intent=new Intent(mContext,MovieDetails.class);
                     //  intent.putParcelableArrayListExtra("image_id",MainActivity.movieUrl.get(position));
                        intent.putExtra("id",position);

                        mContext.startActivity(intent);
                       // ViewHolder viewHolder=new ViewHolder();

                       // LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    // li.inflate(R.layout.imagedetails,null);









                    }
                });






        } else {
            imageView = (ImageView) convertView;
        }


        Picasso.with(mContext).load(MainActivity.movieUrl.get(position)).fit().error(R.drawable.ic_launcher_background).into(imageView);

        return imageView;
    }

    // references to our images

}




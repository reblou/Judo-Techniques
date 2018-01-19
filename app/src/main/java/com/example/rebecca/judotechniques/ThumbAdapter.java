package com.example.rebecca.judotechniques;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rebecca on 14/01/18.
 */

public class ThumbAdapter extends BaseAdapter {
    private final String[] titles;
    private final int[] imageId;
    private Context mContext;

    public ThumbAdapter(Context c, String[] titles, int[] thumbs) {
        mContext = c;
        this.titles = titles;
        this.imageId = thumbs;
    }

    public int getCount() {
        return imageId.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("~~pos: "+position);
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(titles[position]);
            imageView.setImageResource(imageId[position]);
            /*
            grid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = (String) textView.getText();

                    Toast.makeText(mContext, text,
                            Toast.LENGTH_SHORT).show();
                }
            });
            */
        } else {
            grid = (View) convertView;
        }
        return grid;
    }

    /* references to our images
    private int[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4
    };
    */
}

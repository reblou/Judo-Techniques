package com.example.rebecca.judotechniques;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rebecca on 14/01/18.
 */

public class ThumbAdapter extends BaseAdapter {
    private final String[] titles;
    private final int[] imageId;
    private final String[] uploaders;
    private Context mContext;

    public ThumbAdapter(Context c, String[] titles, String[] uploaders, int[] thumbs) {
        mContext = c;
        this.titles = titles;
        this.imageId = thumbs;
        this.uploaders = uploaders;
    }

    public int getCount() {
        return titles.length;
    }

    public Object getItem(int position) {
        return titles[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);

        } else {
            grid = (View) convertView;
        }

        TextView textView = (TextView) grid.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
        TextView upl = grid.findViewById(R.id.grid_uploader);
        upl.setText(uploaders[position]);
        textView.setText(titles[position]);
        imageView.setImageResource(imageId[position]);
        return grid;
    }
}

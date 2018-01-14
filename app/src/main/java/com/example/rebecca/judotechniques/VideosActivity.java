package com.example.rebecca.judotechniques;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class VideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        GridView grid = (GridView) findViewById(R.id.gridview);
        String[] strs = new String[22];

        for (int i = 0; i < strs.length; i++) {

            strs[i] = "hello_" + i;
        }


        grid.setAdapter(new ThumbAdapter(this, strs));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(VideosActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
                Watch(v);
            }
        });
    }

    public void Watch(View view) {
        watchYoutubeVideo("GyHA17-59yk");
        //  http://www.youtube.com/watch?v=GyHA17-59yk
        // Mercuryu Judo
        // https://img.youtube.com/vi/<insert-youtube-video-id-here>/hqdefault.jpg
    }

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}

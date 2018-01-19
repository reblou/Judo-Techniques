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
    public static final String EXTRA_MESSAGE = "com.example.judotechniques.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        GridView grid = (GridView) findViewById(R.id.gridview);
        String[] strs = new String[22];

        for (int i = 0; i < strs.length; i++) {

            strs[i] = "hello_" + i;
        }
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        Toast.makeText(this, message, Toast.LENGTH_LONG);
        System.out.println("~~~" + message + "~~~~~");
        String[] codes = ContentGetter.getCodes(this, message);
        //String[] cds = new String[22];
        //System.arraycopy(codes, 0, cds, 0, 22 );

        grid.setAdapter(new ThumbAdapter(this, codes));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //String clickedText = parent.getItemAtPosition(position).toString();
                //Toast.makeText(VideosActivity.this, clickedText,
                        //Toast.LENGTH_SHORT).show();
                //Watch(v);
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

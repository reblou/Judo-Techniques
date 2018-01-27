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
    String codes[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        GridView grid = (GridView) findViewById(R.id.gridview);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        String trw = message.replaceAll(" ", "-");
        codes = ContentGetter.getCodes(this, trw);
        String[] titles = ContentGetter.getTitles(this, trw);
        String[] uploaders = ContentGetter.getUploaders(this, trw);

        int[] thumbs = ContentGetter.getThumbIds(this, codes);

        grid.setAdapter(new ThumbAdapter(this, titles, uploaders, thumbs));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                String code = codes[position];
                watchYoutubeVideo(code);
            }
        });

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

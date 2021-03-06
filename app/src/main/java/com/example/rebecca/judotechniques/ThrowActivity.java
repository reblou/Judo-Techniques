package com.example.rebecca.judotechniques;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

public class ThrowActivity extends AppCompatActivity {
    ListView list;
    public static final String EXTRA_MESSAGE = "com.example.judotechniques.MESSAGE";
    String category;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw);

        if (savedInstanceState != null) {
            category = savedInstanceState.getString("category");
        } else {
            Intent intent = getIntent();
            category = intent.getStringExtra(EXTRA_MESSAGE);
        }

        String waza[] = ContentGetter.getThrows(category);

        list = (android.widget.ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text2, waza);
        list.setAdapter(arrayAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(ThrowActivity.this, VideosActivity.class);

                int itemPosition = position;
                String itemValue = (String) list.getItemAtPosition(position);
                intent.putExtra(EXTRA_MESSAGE, itemValue);

                startActivity(intent);

            }
        });


    }

}

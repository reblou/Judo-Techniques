package com.example.rebecca.judotechniques;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.judotechniques.MESSAGE";
    ListView simpleList;
    String throwCategories[] = {"Dai Ikkyo", "Dai Nikkyo", "Dai Sankyo", "Dai Yonkyo", "Dai Gokyo", "Others"};

    @Override   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, throwCategories);
        simpleList.setAdapter(arrayAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) simpleList.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, ThrowActivity.class);
                intent.putExtra(EXTRA_MESSAGE, itemValue);

                startActivity(intent);


            }

        });
    }


}

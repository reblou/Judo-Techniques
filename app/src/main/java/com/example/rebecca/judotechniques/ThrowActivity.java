package com.example.rebecca.judotechniques;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

public class ThrowActivity extends AppCompatActivity {
    ListView list;
    //String waza[] = {"ippon seoi nage", "ouchi gari" , "kouchi gari", "tsurikomigoshi"};
    public static final String EXTRA_MESSAGE = "com.example.judotechniques.MESSAGE";
    String category;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString("category", category);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


        // Restore state members from saved instance
        category = savedInstanceState.getString("throw");
        System.out.println("~~~restore cat: " + category);
        }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw);

        if (savedInstanceState != null) {
            category = savedInstanceState.getString("category");
            System.out.println("~~~cat: " + category);
        } else {
            Intent intent = getIntent();
            category = intent.getStringExtra(EXTRA_MESSAGE);
            System.out.println("~~~not saved cat: " + category);
            //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

        String waza[] = ContentGetter.getThrows(category);

        list = (android.widget.ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text2, waza);
        list.setAdapter(arrayAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) list.getItemAtPosition(position);

                /* Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

                */
                Intent intent = new Intent(ThrowActivity.this, VideosActivity.class);
                intent.putExtra(EXTRA_MESSAGE, itemValue);

                startActivity(intent);

            }
        });


    }

}

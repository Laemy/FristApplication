package com.example.ll6x.fristapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity2Activity extends ActionBarActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        //Get ListView object from xml
        listView = (ListView) findViewById(R.id.list_food);

        //Define Array values to show in ListView
        String[] FoodMenu = new String[]{
                "Apple",
                "Banana",
                "Cake",
                "Black Tea",
                "EGG",
                "Candy"
        };

        Integer[] imageId={
                R.drawable.a01,
                R.drawable.a02,
                R.drawable.a03,
                R.drawable.a04,
                R.drawable.a05,
                R.drawable.a06
        };
CustomList adapter = new CustomList(MainActivity2Activity.this,FoodMenu,imageId);

        // Define a new Adepter
        // First parameter - Context
        //Second parameter - Layout for the now
        //Third parameter - ID of the TextView to which the data is written
        //Forth - the Array to data
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1, FoodMenu);

        //Assign adapter to ListView
        listView.setAdapter(adapter);

        //ListView Item Click Listener
        listView.setOnItemClickListener(foodOnItemClick);

    }

    private AdapterView.OnItemClickListener foodOnItemClick=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //ListView Clicked item index
            int itemPosition = position;

            //ListView Clicked item value
            String itemValue = (String) listView.getItemAtPosition(position);

            //Show Alert
            String msg = "Position:" + (itemPosition + 1) + " ListItem:" + itemValue;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG)
                    .show();

        }

    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.ll6x.fristapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

        switch (id) {
            case R.id.goIndex:
                //ShowAlertDialog("Search!", "Search Box");
                Intent mainIntent = new Intent(this, MainActivity.class);
                startActivity(mainIntent);
                MainActivity2Activity.this.finish(); //結束目前Activity
                break;
            case R.id.menuExit:
                new AlertDialog.Builder(MainActivity2Activity.this)
                        .setTitle("Close Program")
                        .setMessage("Are you sure to close the program?")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.star_big_on)
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //
                                    }
                                })
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //TODO Auto-generated method stub
                                        finish();//僅關閉此Activity

                                        //-----開啟mobile Home
                                        Intent intent = new Intent(Intent.ACTION_MAIN);
                                        intent.addCategory(Intent.CATEGORY_HOME);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        //-----
                                    }
                                })
                        .show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }
}

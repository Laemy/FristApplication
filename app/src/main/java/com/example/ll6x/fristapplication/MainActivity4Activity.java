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
import android.widget.GridView;




public class MainActivity4Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        GridView gridView=(GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(),MainActivity4SingleViewActivity.class);
                //pass image index
                i.putExtra("id",position);
                startActivity(i);
            }
        });

    }


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
                MainActivity4Activity.this.finish(); //結束目前Activity
                break;
            case R.id.menuExit:
                new AlertDialog.Builder(MainActivity4Activity.this)
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

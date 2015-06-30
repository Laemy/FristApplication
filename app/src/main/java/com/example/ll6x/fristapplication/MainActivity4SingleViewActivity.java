package com.example.ll6x.fristapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity4SingleViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_single_view);

        //Get intent data
        Intent i =getIntent();

        //Select image id
        int position =i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView=(ImageView) findViewById(R.id.imgSingleView);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4_single_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/


        switch (id) {
            case R.id.goback:
                //ShowAlertDialog("Search!", "Search Box");
                Intent mainIntent = new Intent(this, MainActivity4Activity.class);
                startActivity(mainIntent);
                MainActivity4SingleViewActivity.this.finish(); //結束目前Activity
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}

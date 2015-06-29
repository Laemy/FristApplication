package com.example.ll6x.fristapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


public class MainActivity3Activity extends ActionBarActivity {
    private EditText urlEditText;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        urlEditText = (EditText) this.findViewById(R.id.website);
        webview = (WebView) this.findViewById(R.id.webView);
        WebSettings wvSetting = webview.getSettings();
        wvSetting.setBuiltInZoomControls(true);
        wvSetting.setDisplayZoomControls(true);
        webview.setWebViewClient(new WebClient());
        webview.setWebChromeClient(new WebChromeClient());


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
                Intent mainIntent = new Intent(this, MainActivity.class);
                startActivity(mainIntent);
                MainActivity3Activity.this.finish(); //結束目前Activity
                break;
            case R.id.menuExit:
                new AlertDialog.Builder(MainActivity3Activity.this)
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

    public void btnWebGo_Click(View view) {
        String url = urlEditText.getText().toString();
        if (url != null) {
            if (url.startsWith("http://") == false || url.startsWith("https://") == false) {
                StringBuilder sb = new StringBuilder(url);
                sb.insert(0, "http://");
                url = sb.toString();

            }
            webview.loadUrl(url);
        }

    }

    private class  WebClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            //TODO Auto-generated method stub
            view.loadUrl(Uri.parse(url).toString());
            return  true;
        }

    }
}

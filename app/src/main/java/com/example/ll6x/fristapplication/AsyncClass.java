package com.example.ll6x.fristapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Laemy.Y.Li on 2015/6/30.
 */
public class AsyncClass extends AsyncTask<Void, Integer,String> {
    private Context context;
    ProgressDialog dialog;

    public AsyncClass(ProgressDialog dlg) {
        dialog = dlg;
    }

    // 調用UI線程執行前觸發
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();
    }

    //執行完 onPreExecute()後會執行 dolnBackground 此部分用於執行被景運算
    @Override
    protected String doInBackground(Void... params) {
        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(50);
                publishProgress(i);//發布目前進度
                i++;
            } catch (Exception e) {
                Log.i("Error", e.getMessage());
            }

        }
        return "COMPLETE!";
    }

    //當進度更新時所執行的處理事件
    @Override
    protected void onProgressUpdate(Integer... percent) {
        super.onProgressUpdate(percent);
        dialog.setProgress(percent[0]);
        dialog.setMessage("Downloading..." + String.valueOf(percent[0]) + "%");

    }

    //計算完成後所執行的觸發事件
    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        dialog.dismiss();
    }
}

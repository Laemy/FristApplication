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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import android.os.Handler;


public class MainActivity extends ActionBarActivity {
    private Button mButtonShow, send, login, mbtnFood, mbtnGo2,mbtnGo3;
    private CheckBox mA, mB, mC, mD, mchklndeterminatep;
    private EditText mUsername, mPassword;
    private TextView msg;
    private Spinner mSpnFood;
    private String msFood; //用來存放取得選取Spinner項目內容
    private ProgressBar _CurrentProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonShow = (Button) findViewById(R.id.button);
        mButtonShow.setOnClickListener(btnHOWoNcLICK);

        mA = (CheckBox) findViewById(R.id.cBAA);
        mB = (CheckBox) findViewById(R.id.cBBB);
        mC = (CheckBox) findViewById(R.id.cBCC);
        mD = (CheckBox) findViewById(R.id.cBDD);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(btnCheckBoxSendOnClick);

        mUsername = (EditText) findViewById(R.id.mAccount);
        mPassword = (EditText) findViewById(R.id.mPassword);
        msg = (TextView) findViewById(R.id.txtMessage);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(loginOnClick);

        mbtnFood = (Button) findViewById(R.id.btnfood);
        mbtnFood.setOnClickListener(foodOnClick);
        mSpnFood = (Spinner) findViewById(R.id.spnFood);
        mSpnFood.setOnItemSelectedListener(spnSexOnItemSelected);


        this.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        this.findViewById(R.id.progressBar2).setVisibility(View.INVISIBLE);

        mchklndeterminatep = (CheckBox) this.findViewById(R.id.cBAA);
        _CurrentProgressBar = (ProgressBar) this.findViewById(R.id.progressBar);

        mbtnGo2 = (Button) findViewById(R.id.btnGo2);
        mbtnGo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main2Intent = new Intent(view.getContext(), MainActivity2Activity.class);
                startActivity(main2Intent);
            }
        });
        mbtnGo3 = (Button) findViewById(R.id.btnGo3);
        mbtnGo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main3Intent = new Intent(view.getContext(), MainActivity3Activity.class);
                startActivity(main3Intent);
            }
        });
    }
    //Login
    private View.OnClickListener btnHOWoNcLICK = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String msg = "OK";
            ShowAlertDialog("Android Button", msg);
        }
    };
    private View.OnClickListener loginOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mUsername.getText().toString().equals("Admin") && mPassword.getText().toString().equals("12345")) {
                msg.setText("Success!!");
            } else {
                msg.setText("Failed");
            }
        }
    };

    private View.OnClickListener foodOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ShowAlertDialog("The Best Food ", msFood);
        }
    };

    private AdapterView.OnItemSelectedListener spnSexOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            //TODO Auto-generatrd method stub
            msFood = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    //跳出警告視窗
    private void ShowAlertDialog(String title, String msg) {
        AlertDialog.Builder MyAlerDialog = new AlertDialog.Builder(this);
        MyAlerDialog.setTitle(title);
        MyAlerDialog.setMessage(msg);
        MyAlerDialog.show();
    }

    //Radio的點擊事件
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check Which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked) {
                    ShowAlertDialog("NO1", "you got it !");
                }
                break;
            case R.id.radioButton2:
                if (checked) {
                    ShowAlertDialog("NO2", "you got it !");
                }
                break;
        }
    }

    private View.OnClickListener btnCheckBoxSendOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            StringBuffer OUTst = new StringBuffer();
            OUTst.append("AAA: ")
                    .append(mA.isChecked() + "\n");
            OUTst.append("BBB: ")
                    .append(mB.isChecked() + "\n");
            OUTst.append("CCC: ")
                    .append(mC.isChecked() + "\n");
            OUTst.append("DDD: ")
                    .append(mD.isChecked() + "\n");
            ShowAlertDialog("You check:", OUTst.toString());
        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //menu bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.menuAbout:
                ShowAlertDialog("About", "Information");
                break;
            case R.id.menuSearch:
                ShowAlertDialog("Search!", "Search Box");
                break;
            case R.id.menuExit:
                new AlertDialog.Builder(MainActivity.this)
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
                                        finish();
                                    }
                                })
                        .show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }


    //Loading Bar
    public void btnGO_loading(View view) {
        mProgressStatus = 0;
        if (mchklndeterminatep.isChecked()) {
            _CurrentProgressBar = (ProgressBar) this.findViewById(R.id.progressBar2);
            this.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
            _CurrentProgressBar.setIndeterminate(true);
        } else {
            _CurrentProgressBar = (ProgressBar) this.findViewById(R.id.progressBar);
            this.findViewById(R.id.progressBar2).setVisibility(View.INVISIBLE);
            _CurrentProgressBar.setIndeterminate(false);
        }
        _CurrentProgressBar.setVisibility(View.VISIBLE);
        //Start lengthy operation in a background thread

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Update the progress bar
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            _CurrentProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
            }

        });
        t1.start();

    }
}

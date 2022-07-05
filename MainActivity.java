package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout b_1, b_2, b_3;
    private Button button_1;
    private boolean start_stop = false;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_1 = findViewById(R.id.bulb_1);
        b_2 = findViewById(R.id.bulb_2);
        b_3 = findViewById(R.id.bulb_3);
        button_1 = findViewById(R.id.button1);
    }

    public void onClickStart(View view) {
        if(!start_stop){
            start_stop= true;
            button_1.setText("Stop");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start_stop){
counter++;
switch (counter)
{
    case 1:
        b_1.setBackgroundColor(getResources().getColor(R.color.Red));
        b_2.setBackgroundColor(getResources().getColor(R.color.Grey));
        b_3.setBackgroundColor(getResources().getColor(R.color.Grey));
        break;
    case 2:
        b_1.setBackgroundColor(getResources().getColor(R.color.Grey));
        b_2.setBackgroundColor(getResources().getColor(R.color.Yellow));
        b_3.setBackgroundColor(getResources().getColor(R.color.Grey));
        break;
    case 3:
        b_1.setBackgroundColor(getResources().getColor(R.color.Grey));
        b_2.setBackgroundColor(getResources().getColor(R.color.Grey));
        b_3.setBackgroundColor(getResources().getColor(R.color.Green));
        counter = 0;
        break;
}
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        }else
        {
        start_stop=false;
        button_1.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}






package com.example.a16784.mp6plane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setContentView(new game(this));
    }


    public boolean onKeyDown(int keyCode,KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            long t=System.currentTimeMillis();
            if(t-time<=500){
                exit();
            }else{
                time=t;
                Toast.makeText(getApplicationContext(),"Push again toexit the game",Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }
    public void exit(){
        MainActivity.this.finish();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
                System.exit(0);
            }
        }).start();
    }
}

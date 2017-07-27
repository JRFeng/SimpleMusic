package jrfeng.simplemusic.activity.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

import jrfeng.simplemusic.R;
import jrfeng.simplemusic.activity.main.MainActivity;
import jrfeng.simplemusic.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {
    private boolean mIsActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    private void init() {
        //全屏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //启动定时器, 延时2秒
        final Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mIsActive) {
                    //启动MainActivity
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                timer.cancel();
            }
        }, 2000);
    }


    @Override
    protected void onStop() {
        super.onStop();
        mIsActive = false;
        finish();
    }

}

package com.example.mobile_assignment3;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mobile_assignment3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String NUMBER_KEY = "number";
    private ActivityMainBinding mMainLayout;
    private Button[] mButtons;
    private String mNumber = "";

    MediaPlayer hihat, bass, cymbal, cymbalshort, drumstick, snare, tomdrum, hihatfoot, hihatopen, jokedrum, sadtrombone, snare2, sample;

    // Saves current information when other app is called or change in resolution
    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putString(NUMBER_KEY, mNumber);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hihat= MediaPlayer.create(this, R.raw.hihat);
        bass= MediaPlayer.create(this, R.raw.bass);
        cymbal= MediaPlayer.create(this, R.raw.cymbal);
        cymbalshort= MediaPlayer.create(this, R.raw.cymbalshort);
        drumstick= MediaPlayer.create(this, R.raw.drumstick);
        snare= MediaPlayer.create(this, R.raw.snare);
        tomdrum= MediaPlayer.create(this, R.raw.tomdrum);
        hihatfoot= MediaPlayer.create(this, R.raw.hihatfoot);
        hihatopen= MediaPlayer.create(this, R.raw.hihatopen);
        jokedrum= MediaPlayer.create(this, R.raw.jokedrum);
        sadtrombone= MediaPlayer.create(this, R.raw.sadtrombone);
        snare2= MediaPlayer.create(this, R.raw.snare2);
        sample= MediaPlayer.create(this, R.raw.sample);

        // Recovering the instance state
        if(savedInstanceState!=null) {
            mNumber = savedInstanceState.getString(NUMBER_KEY);
        }

        mMainLayout = ActivityMainBinding.inflate(getLayoutInflater());
        mButtons = new Button[]{
                mMainLayout.button11, mMainLayout.button12, mMainLayout.button13,
                mMainLayout.button21, mMainLayout.button22, mMainLayout.button23,
                mMainLayout.button31, mMainLayout.button32, mMainLayout.button33,
                mMainLayout.button41, mMainLayout.button42, mMainLayout.button43,
                mMainLayout.button51, mMainLayout.buttonDel, mMainLayout.buttonCal
        };
        setContentView(mMainLayout.getRoot());

        // OnClickListener for button
        for (Button button:mButtons) {
            button.setOnClickListener(view -> buttonClick((Button)view));
        }
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 0);
            return;
        }
    }

    // Whenever button is pressed this function called
    private void buttonClick(Button b){
        String val = (String)b.getText();
        if (val.equals("bass")){
            bass.start();
        }
        else if (val.equals("cymbal")){
            cymbal.start();
        }
        else if (val.equals("cymbal-short")){
            cymbalshort.start();
        }
        else if (val.equals("drumstick")){
            drumstick.start();
        }
        else if (val.equals("hihat")){
            hihat.start();
        }
        else if (val.equals("snare")){
            snare.start();
        }
        else if (val.equals("hihat foot")){
            hihatfoot.start();
        }
        else if (val.equals("hihat open")){
            hihatopen.start();
        }
        else if (val.equals("joke drum")){
            jokedrum.start();
        }
        else if (val.equals("sad trombone")){
            sadtrombone.start();
        }
        else if (val.equals("snare2")){
            snare2.start();
        }
        else if (val.equals("tomdrum")){
            tomdrum.start();
        }
        else if (val.equals("sample")){
            sample.start();
        }
        else if (val.equals("clock")){
            Intent intent = new Intent(getApplicationContext(), ClockActivity.class);
            startActivity(intent);
        }
        else if (val.equals("calculator")){
            Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
            startActivity(intent);
        }
    }



}

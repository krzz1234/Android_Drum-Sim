package com.example.mobile_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;


public class ClockActivity extends AppCompatActivity{
    private Clock mClock;
    private final String TAG="DzClock";
    BroadcastReceiver mPcr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        mClock=findViewById(R.id.Clock);

        mPcr =  new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                    int voltage=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);
                    mClock.setVoltage(voltage/1000.0f);
                    int temp=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
                    mClock.setTemperature(temp/10.0f);
                    int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
                    mClock.setStatus(status);
                }
                mClock.onTimeChanged();
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(mPcr,filter);
    }
}

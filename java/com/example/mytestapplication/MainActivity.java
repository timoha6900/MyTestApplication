package com.example.mytestapplication;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Vibrator;
import android.os.Bundle;
import android.os.VibrationEffect;

public class MainActivity extends Activity implements OnClickListener {

    private static final String[] REQUIRED_PERMISSIONS =
            new String[] {
                    Manifest.permission.VIBRATE,
            };

    private static final int REQUEST_CODE_REQUIRED_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    private void initButtons() {
        findViewById(R.id.exit_btn).setOnClickListener(this);
        findViewById(R.id.vibrate_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit_btn:
                final int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                break;

            case R.id.vibrate_btn:
                Vibrator vibr = ((Vibrator) getSystemService(VIBRATOR_SERVICE));
                long[] timings = {0, 300, 200, 200, 0, 300, 200, 200};
                long[] pattern = {300, 200, 300, 200};
                if (Build.VERSION.SDK_INT >= 26) {
                    if(checkPermissions())
                        vibr.vibrate(VibrationEffect.createWaveform(timings, -1));
                } else {
                    vibr.vibrate(pattern, -1);
                }
                break;
        }
    }

    private boolean checkPermissions() {
        boolean granted = true;

        for(String permission : REQUIRED_PERMISSIONS) {
            if (this.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                granted = false;
                break;
            }
        }

        if(!granted) {
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_CODE_REQUIRED_PERMISSIONS);
            return false;
        }
        return true;
    }

}

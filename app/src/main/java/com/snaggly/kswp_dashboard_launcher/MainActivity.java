package com.snaggly.kswp_dashboard_launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String targetPKG = "com.wits.ksw";
    public final static String targetComponent = "com.wits.ksw.launcher.view.DashboardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            Intent kswIntent = getPackageManager().getLaunchIntentForPackage(targetPKG);
            kswIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(kswIntent);
            Thread.sleep(600);

            Intent dashboardIntent = new Intent();
            dashboardIntent.setComponent(new ComponentName(targetPKG, targetComponent));
            startActivity(dashboardIntent);
        }
        catch (Exception e){
            finish();
            Toast.makeText(getApplicationContext(),"Could not find ksw!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkIfKswRunning(){
        ActivityManager activities = (ActivityManager)this.getSystemService(ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> processes = activities.getRunningAppProcesses();
        for (RunningAppProcessInfo process : processes){
            if (process.processName.equals("com.wits.ksw"))
                return true;
        }
        return false;
    }
}
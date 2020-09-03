package com.snaggly.kswp_dashboard_launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            Intent dashboardIntent = new Intent();
            dashboardIntent.setComponent(new ComponentName("com.wits.ksw", "com.wits.ksw.launcher.view.DashboardActivity"));
            startActivity(dashboardIntent);
        }
        catch (Exception e){
            finish();
            Toast.makeText(getApplicationContext(),"Could not find ksw!", Toast.LENGTH_SHORT).show();
        }
    }
}
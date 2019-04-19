package com.example.imagewithservice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Context ctx = this;

        final AlertDialog.Builder alert = new AlertDialog.Builder(DialogActivity.this);
        alert.setTitle("Trip Now");
        alert.setMessage("checking");
        alert.setPositiveButton("Start",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int whichButton)
            {
                Intent mapIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?saddr=" + 29.973137 + "," + 31.017820 + "&daddr=" + 30.019712 + "," + 31.210248));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                    mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(mapIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please install a maps application", Toast.LENGTH_SHORT).show();
                }
                finish();
            }});
        alert.create();
        alert.show();
    }
}

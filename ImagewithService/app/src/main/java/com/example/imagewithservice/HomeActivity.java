package com.example.imagewithservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.imagewithservice.Model.KeyTags;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeActivity extends AppCompatActivity {
    String directory;
    ImageView imageView;
    Bitmap bitmapImage=null;
    String title="Choose App to share";
    private static final String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        if(intent!=null)
        {
           // imageView=(ImageView) findViewById(R.id.myimage);
            directory = intent.getExtras().getString(KeyTags.receivedkey);
            bitmapImage=loadImageFromStorage(directory);
            imageView.setImageBitmap(bitmapImage);
        }
        //*********************************************************************
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null)
        {
            if (type.startsWith("image/")) {
                Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri != null) {
                    Log.e(TAG, "onCreate: " );
                    imageView.setImageURI(imageUri);
                }
            }
        }
        //**************************************************************************
    }
    private Bitmap loadImageFromStorage(String path)
    {
        Bitmap bitmap=null;
        try {
            File file=new File(path, "profile.jpg");
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
          return bitmap;
    }


}

package com.example.texteditedemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
//        Drawable icon = this.getResources().getDrawable(R.drawable.ic_show_pssword);
//        icon.setBounds(50, 1, 100, 100);
//        button.setCompoundDrawables(icon, null, null, null);
        Drawable icon = this.getResources().getDrawable(R.drawable.ic_show_pssword);
        button.setCompoundDrawablesWithIntrinsicBounds(icon, null, icon, null);
    }
}
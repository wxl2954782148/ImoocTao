package com.wang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * @author Administrator
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        closeButton.setOnClickListener(this);
    }

    private void initView() {
        closeButton = findViewById(R.id.imgb_close);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgb_close:
                finish();
                break;
            default:
        }
    }
}
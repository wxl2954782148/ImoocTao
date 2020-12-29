package com.example.texteditedemo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class PasswordEditText extends androidx.appcompat.widget.AppCompatEditText {

    private Drawable imgClear;
    private Context mContex;

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContex = context;
        init();
        //默认隐藏密码
        this.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    private void init() {
        imgClear = mContex.getResources().getDrawable(R.drawable.ic_show_pssword);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }
        });
    }
    private void setDrawable(){
        if (length() < 1)
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        else
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgClear, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgClear != null ){
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 100;
            if (rect.contains(eventX, eventY))
                if(event.getAction() == MotionEvent.ACTION_UP){
                    //按下时显示密码
                    this.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else if (event.getAction() == MotionEvent.ACTION_DOWN){
                    //离开时隐藏密码
                    this.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}

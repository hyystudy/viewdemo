package com.example.sks.myapplication;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

/**
 * Created by sks on 2016/11/23.
 */
public class CustomSwitch extends SwitchCompat {

    public CustomSwitch(Context context) {
        super(context);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        if (checked){
            setTrackResource(R.drawable.switch_big_bg_on);
            setThumbResource(R.drawable.track_on);
        }else {
            setTrackResource(R.drawable.switch_big_bg_off);
            setThumbResource(R.drawable.track_off);
        }
    }
}

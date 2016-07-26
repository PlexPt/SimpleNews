package com.zzh.simplenews.util;

import android.content.Context;

import com.zzh.simplenews.SimpleNewsApplication;


/**
 * Created by zzh on 16/6/2.
 */
public class DimentsUtil {

    private static Context sContext = SimpleNewsApplication.getContext();
    //dp转px
    public static int dp2px(float dp){
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return(int)(dp * scale + 0.5f);
    }

}

package com.example.dupediva2.ui.util;

import android.content.Context;
import java.io.InputStream;
import com.example.dupediva2.R;


public class KeyFileLoader {

    //private static final int resourceId = R.raw.quick_ray_415317_591dcd4dccdb;

    public static InputStream loadKeyFileInputStream(Context context) {
        return context.getResources().openRawResource(R.raw.quick_ray_415317_591dcd4dccdb);
    }
}
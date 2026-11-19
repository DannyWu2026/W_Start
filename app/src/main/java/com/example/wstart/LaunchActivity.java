package com.example.wstart;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public final class LaunchActivity extends Activity {
    private static final String WECHAT_PACKAGE = "com.tencent.mm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Intent wechat = getPackageManager().getLaunchIntentForPackage(WECHAT_PACKAGE);
            if (wechat == null) {
                Toast.makeText(this, R.string.wechat_unavailable, Toast.LENGTH_SHORT).show();
            } else {
                startActivity(wechat);
            }
        } catch (ActivityNotFoundException | SecurityException error) {
            Log.w("W_Start", "Could not launch WeChat", error);
            Toast.makeText(this, R.string.wechat_unavailable, Toast.LENGTH_SHORT).show();
        } finally {
            finish();
        }
    }
}

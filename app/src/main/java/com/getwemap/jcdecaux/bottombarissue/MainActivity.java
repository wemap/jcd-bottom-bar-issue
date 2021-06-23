package com.getwemap.jcdecaux.bottombarissue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener((e) ->
            findViewById(R.id.edit_text).setVisibility(View.VISIBLE)
        );

        KeyboardVisibilityEvent.setEventListener(this,
                isOpen -> getWindow().getDecorView().setSystemUiVisibility(
                        isOpen
                                ? View.SYSTEM_UI_FLAG_VISIBLE
                                : View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }
}
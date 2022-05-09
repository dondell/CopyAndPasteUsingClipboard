package com.professordroid.copyandpasteusingclipboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonCopy = findViewById(R.id.buttonCopy);

        // Gets a handle to the clipboard service.
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != clipboard) {
                    // Creates a new text clip to put on the clipboard
                    ClipData clip = ClipData.newPlainText("Quote", textView.getText().toString());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text was copied", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
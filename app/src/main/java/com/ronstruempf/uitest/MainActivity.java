package com.ronstruempf.uitest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String APP_TAG = "UITest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // Create a button click listener and programmatically bind this to three new test buttons
        //
        View.OnClickListener myonClickListener=
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: Programmatically bind button to click handler
                        if (v instanceof Button) {
                            Log.d(APP_TAG, "Button click on " + ((Button) v).getText());
                        }
                    }
                };

        LinearLayout linLayout=new LinearLayout(this);
        linLayout.setId(100);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        Button b = new Button(this);
        b.setText("Hello Button");
        b.setOnClickListener(myonClickListener);
        linLayout.addView(b);
        b = new Button(this);
        b.setText("Hello Button 2");
        b.setOnClickListener(myonClickListener);
        linLayout.addView(b);
        b = new Button(this);
        b.setText("Hello Button 3");
        b.setOnClickListener(myonClickListener);
        linLayout.addView(b);
        setContentView(linLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int total = 0;

    public void onButtonClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();
        int value = Integer.parseInt(bText);
        total += value;
    }
}

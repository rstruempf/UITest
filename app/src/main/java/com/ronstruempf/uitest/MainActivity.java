package com.ronstruempf.uitest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private static String APP_TAG = "UITest";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // Create a button click listener and programmatically bind this to three new test buttons
        //
        View.OnClickListener myonClickListener =
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: Programmatically bind button to click handler
                        if (v instanceof Button) {
                            Log.d(APP_TAG, "Button click on " + ((Button) v).getText());
                        }
                    }
                };

        LinearLayout linLayout = new LinearLayout(this);
        /*
         * Layout on main page is vertical stack of fragments, which have two buttons horizontal, so
         *   we end up with two columns of buttons
         */
        linLayout.setOrientation(LinearLayout.VERTICAL);
        // layout needs an id to add fragments to it
        linLayout.setId(100);
        setContentView(linLayout);
        /**
         * Fun with fragments
         *  Note: Only add fragments on initial create.  If we are being resumed, the system will
         *     restore the fragments
         */
        if (savedInstanceState == null) {
            // create a fragment and use the fragment manager to add it
            //  Note: These fragments are not build until after onCreate() exits, so we cannot manipulate
            //      them here.
            aFragment frag1 = new aFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(100, frag1);
            ft.commit();
            /**
             * Here we use the same fragment manager, but need a new transaction because the previous
             *   was already committed.  I add multiple fragments in the same transaction this time.
             */
            ft = fm.beginTransaction();
            ft.add(100, new aFragment());
            ft.add(100, new aFragment());
            ft.commit();
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ronstruempf.uitest/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ronstruempf.uitest/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

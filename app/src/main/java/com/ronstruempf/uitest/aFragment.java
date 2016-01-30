package com.ronstruempf.uitest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Playing with Fragments
 *
 * Created by Ron on 1/21/2016.
 */
public class aFragment extends Fragment {

    private final String APP_TAG = "aFragment_Debug";
    private final String SAVE_ID = "aFragment_Id";
    private final String SAVE_TEXT = "aFragment_Text";

    private static int nextId = 110;
    private int ourId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        LinearLayout linLayout = new LinearLayout(getActivity());
        linLayout.setOrientation(LinearLayout.HORIZONTAL);
        final TextView tv=new TextView(getActivity());
        if (state != null) {
            ourId = state.getInt(SAVE_ID);
            if (ourId >= nextId) {
                nextId = ourId + 1;
            }
            tv.setText(state.getCharSequence(SAVE_TEXT));
            Log.d(APP_TAG, "onCreateView: Restoring id=" + ourId + ", text=" + tv.getText());
        }
        else {
            ourId = nextId++;
            tv.setText("Text Entry");
            Log.d(APP_TAG, "onCreateView: New id=" + ourId + ", text=" + tv.getText());
        }
        tv.setId(ourId);
        linLayout.addView(tv);
        View.OnClickListener onclick=
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Button bt=(Button) view;
                        tv.setText(bt.getText());
                    }
                };

        Button b = new Button(getActivity());
        b.setText("Fragment Button 1");
        b.setOnClickListener(onclick);
        linLayout.addView(b);
        b = new Button(getActivity());
        b.setText("Fragment Button 2");
        b.setOnClickListener(onclick);
        linLayout.addView(b);

        return linLayout;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(SAVE_ID, ourId);
        View vw = getView();
        if (vw == null) {
            Log.e(APP_TAG, "Error, getView() returned null on onSaveInstanceState()");
            return;
        }
        TextView tv = (TextView)vw.findViewById(ourId);
        state.putCharSequence(SAVE_TEXT, tv.getText());
        Log.d(APP_TAG, "onSaveInstanceState: Saving id=" + ourId + ", text=" + tv.getText());
    }
}

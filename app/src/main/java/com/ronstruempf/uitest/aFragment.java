package com.ronstruempf.uitest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Ron on 1/21/2016.
 */
public class aFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linLayout=
                new LinearLayout(getActivity());
        linLayout.setOrientation(LinearLayout.HORIZONTAL);
        Button b = new Button(getActivity());
        b.setText("Fragment Button 1");
        linLayout.addView(b);
        b = new Button(getActivity());
        b.setText("Fragment Button 2");
        linLayout.addView(b);

        return linLayout;
    }
}

package com.ronstruempf.uitest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ron on 1/21/2016.
 */
public class aFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linLayout=
                new LinearLayout(getActivity());
        linLayout.setOrientation(LinearLayout.HORIZONTAL);


        final TextView tv=new TextView(getActivity());
        tv.setText("Text Entry");
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


}

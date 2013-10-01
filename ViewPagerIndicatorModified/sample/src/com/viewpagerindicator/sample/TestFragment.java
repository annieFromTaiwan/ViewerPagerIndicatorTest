package com.viewpagerindicator.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ImageView;

public final class TestFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";

    int imageID1, imageID2 = R.drawable.image5;
    /*public TestFragment(int id1, int id2) {
        imageID1=id1;
        imageID2=id2;
    }*/
    public static TestFragment newInstance (int id1, int id2) {
        TestFragment fragment = new TestFragment();

        fragment.imageID1 = id1;
        fragment.imageID2 = id2;

        return fragment;
    }

    /*public static TestFragment newInstance (String content) {
        TestFragment fragment = new TestFragment();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            builder.append(content).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        fragment.mContent = builder.toString();

        return fragment;
    }*/

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
        //    mContent = savedInstanceState.getString(KEY_CONTENT);
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER);
        text.setText("yo");
        text.setTextSize(20 * getResources().getDisplayMetrics().density);
        text.setPadding(20, 20, 20, 20);

        ImageView image1 = new ImageView(getActivity());
        image1.setImageResource(imageID1);
        ImageView image2 = new ImageView(getActivity());
        image2.setImageResource(imageID2);


        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.setOrientation(LinearLayout.VERTICAL);
        //layout.addView(text);
        layout.addView(image1);
        layout.addView(image2);

        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}

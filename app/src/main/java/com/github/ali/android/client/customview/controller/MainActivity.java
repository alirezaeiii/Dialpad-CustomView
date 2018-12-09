package com.github.ali.android.client.customview.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.github.ali.android.client.customview.controller.DialPadActivity.ANIMATION;
import static com.github.ali.android.client.customview.controller.DialPadActivity.DIALPAD_SORT;
import static com.github.ali.android.client.customview.controller.DialPadActivity.CIRCLE;
import static com.github.ali.android.client.customview.controller.DialPadActivity.UNBOUNDED_RIPPLE;
import static com.github.ali.android.client.customview.controller.DialPadActivity.BORDERLINE;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] ITEMS = {"Dialpad1", "Dialpad2", "Dialpad3", "Dialpad4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ListView list = new ListView(this);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ITEMS);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        setContentView(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Intent intent = new Intent(this, DialPadActivity.class);
        switch (position) {
            case 0:
                intent.putExtra(DIALPAD_SORT, CIRCLE);
                break;
            case 1:
                intent.putExtra(DIALPAD_SORT, UNBOUNDED_RIPPLE);
                break;
            case 2:
                intent.putExtra(DIALPAD_SORT, BORDERLINE);
                break;
            case 3:
                intent.putExtra(DIALPAD_SORT, ANIMATION);
                break;
        }
        startActivity(intent);
    }
}

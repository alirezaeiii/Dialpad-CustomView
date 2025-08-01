package com.sample.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] ITEMS = {"Dialpad1", "Dialpad2", "Dialpad3", "Dialpad4", "Dialpad5"};

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
                intent.putExtra(DialPadActivity.DIALPAD_SORT, DialPadActivity.CIRCLE);
                break;
            case 1:
                intent.putExtra(DialPadActivity.DIALPAD_SORT, DialPadActivity.UNBOUNDED_RIPPLE);
                break;
            case 2:
                intent.putExtra(DialPadActivity.DIALPAD_SORT, DialPadActivity.BORDERLINE);
                break;
            case 3:
                intent.putExtra(DialPadActivity.DIALPAD_SORT, DialPadActivity.ANIMATION);
                break;
            case 4:
                intent.putExtra(DialPadActivity.DIALPAD_SORT, DialPadActivity.LINEAR_LAYOUT);
                break;
        }
        startActivity(intent);
    }
}

package com.akashdubey.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button asc,dsc;
    String [] months={"january","february","march","april","may","june","july","august","september","october","november","december"};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asc = (Button) findViewById(R.id.ascBtn);
        dsc = (Button) findViewById(R.id.desBtn);
        lv = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, months);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "item clicked :" + months[i], Toast.LENGTH_SHORT).show();
            }
        });

        asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arrays.sort(months);
                refreshData(months);
            }
        });

        dsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arrays.sort(months,Collections.reverseOrder());
                refreshData(months);
            }
        });
    }

    public void refreshData(final String[] months) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, months);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "item clicked :" + months[i], Toast.LENGTH_SHORT).show();
            }
        });
    }


}

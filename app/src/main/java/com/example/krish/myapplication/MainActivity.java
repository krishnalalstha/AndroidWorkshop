package com.example.krish.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayAdapter<String> listAdapter;
    ArrayList<String> list = new ArrayList<String>();
    ListView mListview;
    Button btnSave;
    EditText textFieldTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();



        list.add("hi");
        list.add("jo");
       // save();
        listAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,
                        read());
        mListview.setAdapter(listAdapter);


    }




    private void initViews(){
        mListview=(ListView)findViewById(R.id.list);
        btnSave=(Button)findViewById(R.id.btnSave);
        textFieldTodo=(EditText)findViewById(R.id.textFieldToDo);


    }


    private void save() {
        try {
            File fileDiir = new File(getFilesDir(), "todo.txt");
            FileUtils.writeLines(fileDiir, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> read(){
        try {
            File fileDiir = new File(getFilesDir(), "todo.txt");
            ArrayList<String> list=new ArrayList<String>(FileUtils.readLines(fileDiir));
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void onButtpnClick(View view) {
        list.add(textFieldTodo.getText().toString());
        listAdapter.notifyDataSetChanged();
    }
}

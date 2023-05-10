package com.example.demotekup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StudenttList extends AppCompatActivity  {

    String studentlist [] = {"Jassem" , "Mouadh" , "Taha" , "Nessrine" , "Ala" ,"Eya"} ;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentview);
        listView = (ListView) findViewById(R.id.studentlistview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, R.layout.studentview , R.id.listview1, studentlist);
        listView.setAdapter(arrayAdapter);
       // listView.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   Toast.makeText(StudenttList.this, "Student Selected", Toast.LENGTH_SHORT).show();
           // }
       // });
    }
}
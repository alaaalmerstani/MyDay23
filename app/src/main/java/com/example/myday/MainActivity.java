package com.example.myday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText titleEditText;
    Spinner spinnerdependency;
    Spinner spinneragent;

    Button buttonAdd;


    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleEditText = findViewById(R.id.titleEditText);
        spinnerdependency = findViewById(R.id.spinnerdependency);
        spinneragent = findViewById(R.id.spinneragent);
        // قائمة الخيارات التي سيتم عرضها في الـ Spinner
        String[] options = {"Option 1", "Option 2", "Option 3"};
        String[] options2 = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);


        db= openOrCreateDatabase("tasks-db", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS dependency (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "description TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS agent (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "description TEXT," +
                "phone TEXT," +
                "address TEXT," +
                "email TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS appointments (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "dependency_id INTEGER," +
                "agent_id INTEGER," +
                "date TEXT," +
                "time TEXT," +
                "new_date TEXT," +
                "new_time TEXT," +
                "status TEXT," +
                "FOREIGN KEY(dependency_id) REFERENCES dependency(id)," +
                "FOREIGN KEY(agent_id) REFERENCES agent(id));");



        }




    @Override
    public void onClick(View v) {
        if(v== buttonAdd){}


        }
}
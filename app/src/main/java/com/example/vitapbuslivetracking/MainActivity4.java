package com.example.vitapbuslivetracking;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private EditText nameEditText, passwordEditText;
    private Button registerButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.drivername);
        passwordEditText = findViewById(R.id.driverpassword);
        registerButton = findViewById(R.id.driverregister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity4.this, "Please enter name and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert the user data into the database
                    ContentValues values = new ContentValues();
                    values.put("username", name);
                    values.put("password", password);
                    long rowId = db.insert("login", null, values);

                    if (rowId != -1) {
                        Toast.makeText(MainActivity4.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity4.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
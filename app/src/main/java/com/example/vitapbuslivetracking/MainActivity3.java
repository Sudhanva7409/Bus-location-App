package com.example.vitapbuslivetracking;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText nameEditText, passwordEditText;
    private Button loginButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        nameEditText = findViewById(R.id.nameEditText2);
        passwordEditText = findViewById(R.id.nameEditText3);
        loginButton = findViewById(R.id.button6);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Please enter name and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the entered credentials exist in the database
                    String[] projection = {"username"};
                    String selection = "username = ? AND password = ?";
                    String[] selectionArgs = {name, password};

                    Cursor cursor = db.query("login", projection, selection, selectionArgs, null, null, null);
                    if (cursor.getCount() > 0) {
                        // Credentials exist, open MainActivity8
                        Intent intent = new Intent(MainActivity3.this, MainActivity7.class);
                        startActivity(intent);
                    } else {
                        // Invalid credentials
                        Toast.makeText(MainActivity3.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                }
            }
        });
        loginButton = findViewById(R.id.button71);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}
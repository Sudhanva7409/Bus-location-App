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

public class MainActivity6 extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        usernameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity6.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the username and password match
                    SQLiteDatabase db = databaseHelper.getReadableDatabase();
                    String selection = "username = ? AND password = ?";
                    String[] selectionArgs = {username, password};
                    Cursor cursor = db.query("login", null, selection, selectionArgs, null, null, null);

                    if (cursor.moveToFirst()) {
                        // Username and password match, navigate to MainActivity8
                        Intent intent = new Intent(MainActivity6.this, MainActivity9.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Invalid username or password
                        Toast.makeText(MainActivity6.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }

                    cursor.close();
                }
            }
        });
        loginButton = findViewById(R.id.registerButton2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity6.this, MainActivity5.class);
                startActivity(intent);
            }
        });
    }
}
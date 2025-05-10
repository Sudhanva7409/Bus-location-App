package com.example.vitapbuslivetracking;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    private EditText nameEditText, passwordEditText;
    private Button registerButton;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity5.this, "Please enter name and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert the user data into the database
                    ContentValues values = new ContentValues();
                    values.put("username", name); // column name is "username"
                    values.put("password", password);

                    long rowId = db.insert("login", null, values); // table name is "login"

                    if (rowId != -1) {
                        Toast.makeText(MainActivity5.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity5.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database connection
        db.close();
    }
}
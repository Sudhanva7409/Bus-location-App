package com.example.vitapbuslivetracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);


        RadioButton route1RadioButton = findViewById(R.id.radioButton21);
        RadioButton route2RadioButton = findViewById(R.id.radioButton22);
        RadioButton route3RadioButton = findViewById(R.id.radioButton23);

        route1RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.vitapbuslivetracking.MainActivity16.this, MainActivity17.class);
                startActivity(intent);
            }
        });

        route2RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.vitapbuslivetracking.MainActivity16.this, MainActivity18.class);
                startActivity(intent);
            }
        });

        route3RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.vitapbuslivetracking.MainActivity16.this, MainActivity18.class);
                startActivity(intent);
            }
        });
    }
}

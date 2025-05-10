package com.example.vitapbuslivetracking;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class MainActivity10  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        RadioButton route1RadioButton = findViewById(R.id.radioButton5);
        RadioButton route2RadioButton = findViewById(R.id.radioButton4);
        RadioButton route3RadioButton = findViewById(R.id.radioButton2);
        RadioButton route4RadioButton = findViewById(R.id.radioButton3);
        RadioButton route5RadioButton = findViewById(R.id.radioButton6);

        route1RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity10.this, MainActivity11.class);
                startActivity(intent);
            }
        });

        route2RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity10.this, MainActivity12.class);
                startActivity(intent);
            }
        });

        route3RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity10.this, MainActivity13.class);
                startActivity(intent);
            }
        });

        route4RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity10.this, MainActivity14.class);
                startActivity(intent);
            }
        });

        route5RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity10.this, MainActivity15.class);
                startActivity(intent);
            }
        });
    }
}

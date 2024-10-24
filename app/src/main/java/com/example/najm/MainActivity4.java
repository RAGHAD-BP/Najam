package com.example.najm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_main4);

        Button button = findViewById(R.id.ToDoList);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this, ToDolistActivity.class);
                startActivity(i);
            }
        });
        Button bu = findViewById(R.id.Qustion);
        bu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this, activityQ.class);
                startActivity(i);
            }
        });
        Button S = findViewById(R.id.scashol);
        S.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this, schedule.class);
                startActivity(i);
            }
        });
        Button timePlan = findViewById(R.id.Plan);
        timePlan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this, timePlan.class);
                startActivity(i);
            }
        });

    }
}
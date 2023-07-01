package com.example.blackjackstrategy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Button buttonHit;
    private Button buttonStay;
    private Button buttonA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Find the buttons in the layout
        buttonHit = findViewById(R.id.button_hit);
        buttonStay = findViewById(R.id.button_stay);
        buttonA = findViewById(R.id.buttonA);

        // Set click listeners for the buttons
        buttonHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions when "Hit" button is clicked
                // Add your logic here
                Toast.makeText(GameActivity.this, "You clicked Hit", Toast.LENGTH_SHORT).show();
            }
        });

        buttonStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions when "Stay" button is clicked
                // Add your logic here
                Toast.makeText(GameActivity.this, "You clicked Stay", Toast.LENGTH_SHORT).show();
            }
        });

        buttonStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions when "A" button is clicked
                // Add your logic here
                Toast.makeText(GameActivity.this, "You clicked A", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
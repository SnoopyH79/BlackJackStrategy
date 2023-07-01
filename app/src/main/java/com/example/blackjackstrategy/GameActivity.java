package com.example.blackjackstrategy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    private Button selectedButton;
    private List<Button> cardButtons;

    private int playerValue;
    private TextView playerValueTextView;
    private int[] cardButtonIds = {
            R.id.button_A,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9,
            R.id.button_10,
            R.id.button_J,
            R.id.button_Q,
            R.id.button_K
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playerValue = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        cardButtons = new ArrayList<>();
        for (int id : cardButtonIds) {
            Button button = findViewById(id);
            cardButtons.add(button);
            int index = cardButtons.size() - 1;
            button.setOnClickListener(v -> handleCardButtonClick(cardButtons.get(index), index + 1));
        }
        playerValueTextView = findViewById(R.id.textView_playerValue);
    }

    private void handleCardButtonClick(Button button, int cardValue) {
        if (selectedButton != null && selectedButton != button) {
            selectedButton.setSelected(false);
            playerValue = 0;
        }

        if(button.isSelected())
        {
            playerValue -= cardValue;
        }
        else
        {
            playerValue += cardValue;
        }

        button.setSelected(!button.isSelected());
        selectedButton = button;

        playerValueTextView.setText("Player Value: " + playerValue);
    }
}
package com.example.blackjackstrategy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    private List<Button> firstCardButtons;
    private List<Button> secondCardButtons;
    private List<Button> dealerCardButtons;

    private int playerValue;
    private int dealerValue;
    private TextView playerValueTextView;
    private TextView dealerValueTextView;
    private final int[] firstCardButtonIds = {
            R.id.btn_First_A,
            R.id.btn_First_2,
            R.id.btn_First_3,
            R.id.btn_First_4,
            R.id.btn_First_5,
            R.id.btn_First_6,
            R.id.btn_First_7,
            R.id.btn_First_8,
            R.id.btn_First_9,
            R.id.btn_First_10,
            R.id.btn_First_J,
            R.id.btn_First_Q,
            R.id.btn_First_K
    };

    private final int[] secondCardButtonIds = {
            R.id.btn_Second_A,
            R.id.btn_Second_2,
            R.id.btn_Second_3,
            R.id.btn_Second_4,
            R.id.btn_Second_5,
            R.id.btn_Second_6,
            R.id.btn_Second_7,
            R.id.btn_Second_8,
            R.id.btn_Second_9,
            R.id.btn_Second_10,
            R.id.btn_Second_J,
            R.id.btn_Second_Q,
            R.id.btn_Second_K
    };

    private final int[] dealerCardButtonIds = {
            R.id.btn_Dealer_A,
            R.id.btn_Dealer_2,
            R.id.btn_Dealer_3,
            R.id.btn_Dealer_4,
            R.id.btn_Dealer_5,
            R.id.btn_Dealer_6,
            R.id.btn_Dealer_7,
            R.id.btn_Dealer_8,
            R.id.btn_Dealer_9,
            R.id.btn_Dealer_10,
            R.id.btn_Dealer_J,
            R.id.btn_Dealer_Q,
            R.id.btn_Dealer_K
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        firstCardButtons = new ArrayList<>();
        for (int id : firstCardButtonIds) {
            Button button = findViewById(id);
            firstCardButtons.add(button);
            button.setOnClickListener(v -> handleCardButtonClick(button, firstCardButtons));
        }

        secondCardButtons = new ArrayList<>();
        for (int id : secondCardButtonIds) {
            Button button = findViewById(id);
            secondCardButtons.add(button);
            button.setOnClickListener(v -> handleCardButtonClick(button, secondCardButtons));
        }

        dealerCardButtons = new ArrayList<>();
        for (int id : dealerCardButtonIds) {
            Button button = findViewById(id);
            dealerCardButtons.add(button);
            button.setOnClickListener(v -> handleDealerCardButtonClick(button, dealerCardButtons));
        }

        playerValueTextView = findViewById(R.id.textView_playerValue);
        playerValue = 0;
        dealerValueTextView = findViewById(R.id.textView_dealerValue);
        dealerValue = 0;
        updatePlayerValue();
    }

    private void handleCardButtonClick(Button button, List<Button> cardButtons) {
        int cardValue = getCardValue(button.getId(), cardButtons);

        if (button.isSelected()) {
            button.setSelected(false);
            playerValue -= cardValue;
        } else {
            button.setSelected(true);
            playerValue += cardValue;
            for (Button cardButton : cardButtons) {
                if (cardButton != button && cardButton.isSelected()) {
                    cardButton.setSelected(false);
                    playerValue -= getCardValue(cardButton.getId(), cardButtons);
                }
            }
        }

        updatePlayerValue();
    }

    private void handleDealerCardButtonClick(Button button, List<Button> cardButtons) {
        int cardValue = getCardValue(button.getId(), cardButtons);

        if (button.isSelected()) {
            button.setSelected(false);
            dealerValue -= cardValue;
        } else {
            button.setSelected(true);
            dealerValue += cardValue;
            for (Button cardButton : cardButtons) {
                if (cardButton != button && cardButton.isSelected()) {
                    cardButton.setSelected(false);
                    dealerValue -= getCardValue(cardButton.getId(), cardButtons);
                }
            }
        }

        updateDealerValue();
    }

    private int getCardValue(int buttonId, List<Button> cardButtons) {
        Button button = findViewById(buttonId);
        String buttonText = button.getText().toString();

        if (buttonText.equals("J") || buttonText.equals("Q") || buttonText.equals("K")) {
            return 10;
        } else {
            return cardButtons.indexOf(button) + 1;
        }
    }

    private void updatePlayerValue() {
        String valueText;
        if (playerValue <= 11 && hasAce()) {
            valueText = "Player Value: " + playerValue + " or " + (playerValue + 10);
        } else {
            valueText = "Player Value: " + playerValue;
        }
        playerValueTextView.setText(valueText);
    }

    private void updateDealerValue() {
        String valueText;
        if (dealerValue == 1) {
            valueText = "Dealer Value: " + dealerValue + " or " + (dealerValue + 10);
        } else {
            valueText = "Dealer Value: " + dealerValue;
        }
        dealerValueTextView.setText(valueText);
    }

    private boolean hasAce() {
        for (Button button : firstCardButtons) {
            if (button.isSelected() && button.getId() == R.id.btn_First_A) {
                return true;
            }
        }
        for (Button button : secondCardButtons) {
            if (button.isSelected() && button.getId() == R.id.btn_Second_A) {
                return true;
            }
        }
        return false;
    }
}
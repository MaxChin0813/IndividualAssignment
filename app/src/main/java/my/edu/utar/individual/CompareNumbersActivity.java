package my.edu.utar.individual;

// CompareNumbersActivity.java

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CompareNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_numbers);

        TextView num1TextView = findViewById(R.id.num1TextView);
        TextView num2TextView = findViewById(R.id.num2TextView);
        TextView textView = findViewById(R.id.textView);
        Button greaterThanButton = findViewById(R.id.greaterThanButton);
        Button lessThanButton = findViewById(R.id.lessThanButton);

        // Generate random numbers
        int num1 = generateRandomNumber();
        int num2 = generateRandomNumber();

        // Display random numbers
        num1TextView.setText(String.valueOf(num1));
        num2TextView.setText(String.valueOf(num2));

        String sentence = "Is " + num1 + " greater or less than " + num2 + "?";
        textView.setText(sentence);


        // Check if num1 > num2
        greaterThanButton.setOnClickListener(view -> {
            if (num1 > num2)
                showCorrectMessage();
            else
                showIncorrectMessage();
        });

        // Check if num1 < num2
        lessThanButton.setOnClickListener(view -> {
            if (num1 < num2)
                showCorrectMessage();
            else
                showIncorrectMessage();
        });
    }

    private int generateRandomNumber() {
        // Generate a random number between 1 and 100
        return new Random().nextInt(100) + 1;
    }

    private void showCorrectMessage() {
        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
    }

    private void showIncorrectMessage() {
        Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
    }
}

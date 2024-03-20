package my.edu.utar.individual;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class ComposeNumbersActivity extends AppCompatActivity {
    private int targetNumber;
    private ArrayList<Integer> selectedNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_numbers);

        TextView targetNumberTextView = findViewById(R.id.targetNumberTextView);
        Button numberButton1 = findViewById(R.id.numberButton1);
        Button numberButton2 = findViewById(R.id.numberButton2);
        Button numberButton3 = findViewById(R.id.numberButton3);
        Button numberButton4 = findViewById(R.id.numberButton4);
        Button submitButton = findViewById(R.id.submitButton);

        // Generate a target number
        targetNumber = generateTargetNumber();

        // Display the target number
        targetNumberTextView.setText(String.valueOf(targetNumber));

        // Generate and display smaller numbers
        displaySmallerNumbers();

        // Initialize selected numbers list
        selectedNumbers = new ArrayList<>();

        // Set onClickListener for number buttons
        numberButton1.setOnClickListener(v -> onNumberButtonClicked(Integer.parseInt(numberButton1.getText().toString())));
        numberButton2.setOnClickListener(v -> onNumberButtonClicked(Integer.parseInt(numberButton2.getText().toString())));
        numberButton3.setOnClickListener(v -> onNumberButtonClicked(Integer.parseInt(numberButton3.getText().toString())));
        numberButton4.setOnClickListener(v -> onNumberButtonClicked(Integer.parseInt(numberButton4.getText().toString())));

        // Set onClickListener for submit button
        submitButton.setOnClickListener(v -> checkSumEqualsTarget());
    }

    private int generateTargetNumber() {
        // Generate a random target number between 10 and 99
        return new Random().nextInt(90) + 10;
    }

    private void displaySmallerNumbers() {
        Button numberButton1 = findViewById(R.id.numberButton1);
        Button numberButton2 = findViewById(R.id.numberButton2);
        Button numberButton3 = findViewById(R.id.numberButton3);
        Button numberButton4 = findViewById(R.id.numberButton4);

        Random random = new Random();
        int num1 = random.nextInt(targetNumber - 1) + 1;
        int num2 = targetNumber - num1;
        int num3 = random.nextInt(targetNumber - num1 - 1) + 1;
        int num4 = targetNumber - num3;

        numberButton1.setText(String.valueOf(num1));
        numberButton2.setText(String.valueOf(num2));
        numberButton3.setText(String.valueOf(num3));
        numberButton4.setText(String.valueOf(num4));
    }

    private void onNumberButtonClicked(int number) {
        // Toggle selection for the clicked number
        if (selectedNumbers.contains(number)) {
            selectedNumbers.remove(Integer.valueOf(number));
        } else {
            selectedNumbers.add(number);
        }

        // Update the UI to display the selected numbers
        TextView selectedNumbersTextView = findViewById(R.id.selectedNumbersTextView);
        StringBuilder selectedNumbersString = new StringBuilder();
        for (int num : selectedNumbers) {
            selectedNumbersString.append(num).append(" + ");
        }
        // Remove the trailing comma and space
        if (selectedNumbersString.length() > 0) {
            selectedNumbersString.setLength(selectedNumbersString.length() - 2);
        }
        selectedNumbersTextView.setText(selectedNumbersString.toString());
    }


    private void checkSumEqualsTarget() {
        int sum = 0;
        for (int num : selectedNumbers) {
            sum += num;
        }

        if (sum == targetNumber) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }
}

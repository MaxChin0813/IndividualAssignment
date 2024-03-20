package my.edu.utar.individual;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up click listeners for navigation buttons
        findViewById(R.id.btn_compare_numbers).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CompareNumbersActivity.class));
        });

        findViewById(R.id.btn_order_numbers).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, OrderNumbersActivity.class));
        });

        findViewById(R.id.btn_compose_numbers).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ComposeNumbersActivity.class));
        });
    }
}


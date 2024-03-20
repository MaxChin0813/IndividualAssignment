package my.edu.utar.individual;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OrderNumbersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NumberAdapter adapter;
    private ArrayList<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_numbers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        numbers = generateRandomNumbers();
        adapter = new NumberAdapter(numbers);
        recyclerView.setAdapter(adapter);

        // Enable drag-and-drop functionality
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                0) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                Collections.swap(numbers, fromPosition, toPosition);
                adapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // No need to implement since we're only dealing with vertical drag-and-drop
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);

        // Set up submit button click listener
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(view -> checkOrder());
    }

    private ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt(100) + 1); // Generate numbers between 1 and 100
        }
        return numbers;
    }

    private void checkOrder() {
        boolean isAscending = true;
        boolean isDescending = true;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                isAscending = false;
            }
            if (numbers.get(i) < numbers.get(i + 1)) {
                isDescending = false;
            }
        }
        if (isAscending) {
            Toast.makeText(this, "Numbers are in ascending order!", Toast.LENGTH_SHORT).show();
        } else if (isDescending) {
            Toast.makeText(this, "Numbers are in descending order!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Numbers are not in ascending or descending order!", Toast.LENGTH_SHORT).show();
        }
    }
}

package my.edu.utar.individual;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {
    private ArrayList<Integer> numbers;

    public NumberAdapter(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_number, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        int number = numbers.get(position);
        holder.bind(number);
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    static class NumberViewHolder extends RecyclerView.ViewHolder {
        private TextView numberTextView;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
        }

        public void bind(int number) {
            numberTextView.setText(String.valueOf(number));
        }
    }
}

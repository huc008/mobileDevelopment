package com.example.numad23sp_huiyingchen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<CardObject> cardList;

    public Adapter (List<CardObject> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_link,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String name = cardList.get(position).getName();
        String url = cardList.get(position).getUrl();

        holder.setData(name, url);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView1;
        private TextView textView2;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            textView1 = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.url);
        }

        public void setData(String name, String url) {
            textView1.setText(name);
            textView2.setText(url);
        }
    }
}

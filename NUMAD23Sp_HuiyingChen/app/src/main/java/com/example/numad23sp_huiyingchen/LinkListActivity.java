package com.example.numad23sp_huiyingchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.numad23sp_huiyingchen.databinding.ActivityAboutMeBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class LinkListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    List<CardObject> cardList;
    LinearLayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_list);

        initData();
        initRecycleView();

    }

    private void initData() {
        cardList = new ArrayList<>();
        cardList.add(new CardObject("Alice", "www.alice.com"));
        cardList.add(new CardObject("Wendy", "www.wendy.com"));
    }

    private void initRecycleView() {
        recyclerView=findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(cardList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
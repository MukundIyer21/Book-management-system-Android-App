package com.example.bookish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAllBooks;
    private AllBooksAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter=new AllBooksAdapter(this,"allBooks");
        recyclerViewAllBooks=findViewById(R.id.RecyclerAllBooks);

        recyclerViewAllBooks.setAdapter(adapter);
        recyclerViewAllBooks.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setBooks(utils.getInstance(this).getAllBooks());

    }

}
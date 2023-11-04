package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity{
    private RecyclerView booksRecycler;
    private BooksRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
/*
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
*/
        booksRecycler=findViewById(R.id.booksRecycler);
        adapter=new BooksRecyclerViewAdapter(this,"allBooks");
        booksRecycler.setAdapter(adapter);

        booksRecycler.setLayoutManager(new LinearLayoutManager(this));
        /*ArrayList<Book> books=new ArrayList<>();
        books.add(new Book(001,"Ikigai","Hector Garcia",208,"https://cdn2.penguin.com.au/covers/original/9781786330895.jpg"
                ,"The intersection of what you love, what you are good at, what the world needs, and what you can be paid for"
        ,"Long Description"));
        books.add(new Book(007,"Murder on the Orient Express","Agartha Christie",208,"https://assets-eu-01.kc-usercontent.com/bcd02f72-b50c-0179-8b4b-5e44f5340bd4/5f0a1a3e-c9d7-4271-b37c-e98c6bf111d8/murder-on-the-orient-express-book-cover.jpg"
                ,"A classic Hercule Poirot Mystery"
                ,"Long Description"));*/
        adapter.setBooks(Utils.getInstance().getAllBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    /*@Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
    }*/
}
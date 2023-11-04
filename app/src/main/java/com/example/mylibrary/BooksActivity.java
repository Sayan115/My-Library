package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {
    private ImageView imgBook;
    private TextView txtBookName, txtAuthor, txtPages, txtDes;
    private Button btnAddtoCurrentlyReading, btnAddtoALreadyRead, btnAddtoFav, btnAddtoWanttoRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        initViews();

/*
        String longDes="The book introduces the concept of ikigai and how it helps the Japanese people live a healthy life even at an old age." +
                "\nThen the authors describe the secrets of anti-aging and how stress can degrade our health. " +
                "\nConcepts of Logo-therapy and case studies where people found their purpose are described." +
                "\nIkigai is a Japanese concept that means \"a reason for being\". It is the intersection of what you love, what you are good at, what the world needs, and what you can be paid for. The book Ikigai: The Japanese Secret to a Long and Happy Life, written by Héctor García and Francesc Miralles, explores this idea and how it can help people find happiness and purpose in their lives. The book draws on the wisdom of the people of Okinawa, Japan, who have the longest life expectancy in the world. The book offers practical tips and exercises to help readers discover their own ikigai and live a more fulfilling and meaningful life. The authors also share stories and insights from various experts and researchers on topics such as flow, mindfulness, resilience, and gratitude. The book is divided into ten chapters, each focusing on a different aspect of ikigai. " +
                "\nThe book aims to inspire readers to embrace their ikigai and pursue their passions with joy and enthusiasm.";
        Book books=new Book(001,"Ikigai","Hector Garcia",208,"https://cdn2.penguin.com.au/covers/original/9781786330895.jpg"
                ,"The intersection of what you love, what you are good at, what the world needs, and what you can be paid for"
                ,longDes);*/
        Intent intent=getIntent();
        if(intent!=null)
        {
            int bookId=intent.getIntExtra("bookId",-1);
            if(bookId!=-1)
            {
                Book incomingBook=Utils.getInstance().getBookbyId(bookId);
                if(incomingBook!=null)
                {
                    setData(incomingBook);

                    handelAlreadyRead(incomingBook);
                    handelWanttoRead(incomingBook);
                    handelCurrentlyReadingBooks(incomingBook);
                    handelFavBooks(incomingBook);
                }
            }
        }
    }

    private void handelFavBooks( Book book) {
        ArrayList<Book> favBooks=Utils.getInstance().getFavouriteBooks();
        boolean existsinFavBooks=false;
        for(Book b:favBooks){
            if(b.getId()== book.getId())
            {
                existsinFavBooks=true;
            }

        }
        if(existsinFavBooks)
        {
            btnAddtoFav.setEnabled(false);
        }
        else
        {
            btnAddtoFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addtoFavReading(book))
                    {
                        Toast.makeText(BooksActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BooksActivity.this, FavouriteBookActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened! Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handelCurrentlyReadingBooks( Book book) {
        ArrayList<Book> currentlyReadBooks=Utils.getInstance().getCurrentlyReadingBooks();
        boolean existsinCurrentlyReadBooks=false;
        for(Book b:currentlyReadBooks){
            if(b.getId()== book.getId())
            {
                existsinCurrentlyReadBooks=true;
            }

        }
        if(existsinCurrentlyReadBooks)
        {
            btnAddtoCurrentlyReading.setEnabled(false);
        }
        else
        {
            btnAddtoCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addtoCurrentlyReading(book))
                    {
                        Toast.makeText(BooksActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BooksActivity.this, CurrentlyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened! Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handelWanttoRead(Book book) {
        ArrayList<Book> wantoReadBooks=Utils.getInstance().getWanttoReadBooks();
        boolean existsinWanttoReadBooks=false;
        for(Book b:wantoReadBooks){
            if(b.getId()== book.getId())
            {
                existsinWanttoReadBooks=true;
            }

        }
        if(existsinWanttoReadBooks)
        {
            btnAddtoWanttoRead.setEnabled(false);
        }
        else
        {
            btnAddtoWanttoRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToWantoRead(book))
                    {
                        Toast.makeText(BooksActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BooksActivity.this, WantoReadBookActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened! Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handelAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks=Utils.getInstance().getAlreadyReadBooks();
        boolean existsinAlreadyReadBooks=false;
        for(Book b:alreadyReadBooks){
            if(b.getId()== book.getId())
            {
                existsinAlreadyReadBooks=true;
            }

        }
        if(existsinAlreadyReadBooks)
        {
            btnAddtoALreadyRead.setEnabled(false);
        }
        else
        {
            btnAddtoALreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToAlreadyRead(book))
                    {
                        Toast.makeText(BooksActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BooksActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BooksActivity.this, "Something wrong happened! Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void setData(Book books)
    {
        txtBookName.setText(books.getName());
        txtPages.setText(String.valueOf(books.getPages()));
        txtAuthor.setText(books.getAuthor());
        txtDes.setText(books.getLongDesc());
        Glide.with(this)
                .asBitmap().load(books.getImageURL())
                .into(imgBook);
    }
    public void initViews()
    {
        imgBook = findViewById(R.id.imgBook);

        txtBookName = findViewById(R.id.txtBookName);
        txtPages = findViewById(R.id.txtPages);
        txtDes = findViewById(R.id.txtLongDes);
        txtAuthor = findViewById(R.id.txtAuthor);

        btnAddtoALreadyRead = findViewById(R.id.btnAddtoAlreadyRead);
        btnAddtoFav = findViewById(R.id.btnAddtoFav);
        btnAddtoCurrentlyReading=findViewById(R.id.btnAddtoCurrentlyReading);
        btnAddtoWanttoRead=findViewById(R.id.btnAddtoWantRead);
    }
}
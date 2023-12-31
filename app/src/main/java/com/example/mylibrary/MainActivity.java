package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private Button btnAllBooks, btnCurrentReading, btnAlreadyRead, btnWanttoRead, btnAbout,btnFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CurrentlyReadBookActivity.class);
                startActivity(intent);
            }
        });
        btnWanttoRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, WantoReadBookActivity.class);
                startActivity(intent);
            }
        });
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FavouriteBookActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Welcome to the Library app.\nYour personalised application to keep track of your books\n" +
                        "Check my Website to know about me:");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
    }


    private void initViews()
    {
        btnAllBooks=findViewById(R.id.btnAllBooks);
        btnAbout=findViewById(R.id.btnAbout);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
        btnCurrentReading=findViewById(R.id.btnCurrentReading);
        btnWanttoRead=findViewById(R.id.btnWanttoRead);
        btnFav=findViewById(R.id.btnFav);
    }
}
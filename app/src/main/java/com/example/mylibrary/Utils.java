package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wanttoReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks;
    private Utils() {
        if(allBooks==null)
        {
            allBooks=new ArrayList<>();
            initData();
        }
        if(alreadyReadBooks==null)
        {
            alreadyReadBooks=new ArrayList<>();
        }
        if(wanttoReadBooks==null)
        {
            wanttoReadBooks=new ArrayList<>();
        }
        if(currentlyReadingBooks==null)
        {
            currentlyReadingBooks=new ArrayList<>();
        }
        if(favouriteBooks==null)
        {
            favouriteBooks=new ArrayList<>();
        }

    }

    private void initData() {
        //TODO: add initial data

        allBooks.add(new Book(1,"Ikigai","Hector Garcia",208,"https://cdn2.penguin.com.au/covers/original/9781786330895.jpg"
                ,"The intersection of what you love, what you are good at, what the world needs, and what you can be paid for"
                ,"Long Description"));
        allBooks.add(new Book(2,"Murder on the Orient Express","Agartha Christie",274,"https://assets-eu-01.kc-usercontent.com/bcd02f72-b50c-0179-8b4b-5e44f5340bd4/5f0a1a3e-c9d7-4271-b37c-e98c6bf111d8/murder-on-the-orient-express-book-cover.jpg"
                ,"A classic Hercule Poirot Mystery"
                ,"Long Description"));
    }

    public static Utils getInstance() {
        if(instance!=null)
            return instance;
        else {
            instance=new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWanttoReadBooks() {
        return wanttoReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public Book getBookbyId(int id)
    {
        for(Book b:allBooks)
            if(b.getId()==id)
            {
                return b;
            }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantoRead(Book book){
        return wanttoReadBooks.add(book);
    }

    public boolean addtoCurrentlyReading(Book book)
    {
        return currentlyReadingBooks.add(book);
    }
    public boolean addtoFavReading(Book book)
    {
        return favouriteBooks.add(book);
    }

    public boolean removeFromAlreadyReadBooks(Book book)
    {
        return alreadyReadBooks.remove(book);
    }

    public boolean removeFromCurrentlyReadBooks(Book book)
    {
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeFromFavouriteBooks(Book book)
    {
        return favouriteBooks.remove(book);
    }
    public boolean removeFromWanttoReadBooks(Book book)
    {
        return wanttoReadBooks.remove(book);
    }



}

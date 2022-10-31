package com.example.bookish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";

    private Button addToCurrentlyReadingBtn,addToFavouriteBtn,addToReadBtn,addToWishListBtn;
    private TextView  bookNameTxt,authorTxt,noOfPagesTxt,descriptionTxt;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();
        
        Intent intent = getIntent();
        if(null!=intent){
            int bookId=intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId!=-1){
                Book incomingBook = utils.getInstance(this).getBookById(bookId);
                if(null!=incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleFavouriteBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                }
            }
        }

    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> CurrentlyReadingBooks = utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existsInCurrentlyReadingBooks=false;

        for(Book b:CurrentlyReadingBooks){
            if(b.getId()==book.getId()){
                existsInCurrentlyReadingBooks=true;
            }
        }

        if(existsInCurrentlyReadingBooks){
            addToCurrentlyReadingBtn.setEnabled(false);
        }
        else{
            addToCurrentlyReadingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(utils.getInstance(BookActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,CurrentlyReading.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"The Book already exists in the list",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFavouriteBooks(final Book book) {
        ArrayList<Book> favouriteBooks = utils.getInstance(this).getFavouriteBooks();

        boolean existsInFavouriteBooks=false;

        for(Book b:favouriteBooks){
            if(b.getId()==book.getId()){
                existsInFavouriteBooks=true;
            }
        }

        if(existsInFavouriteBooks){
            addToFavouriteBtn.setEnabled(false);
        }
        else{
            addToFavouriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(utils.getInstance(BookActivity.this).addToFavourites(book)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,FavouriteActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"The Book already exists in the list",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = utils.getInstance(this).getWishListBooks();

        boolean existsInWishListBooks=false;

        for(Book b:wantToReadBooks){
            if(b.getId()==book.getId()){
                existsInWishListBooks=true;
            }
        }

        if(existsInWishListBooks){
            addToWishListBtn.setEnabled(false);
        }
        else{
            addToWishListBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(utils.getInstance(BookActivity.this).addToWantToRead(book)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,WantToRead.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"The Book already exists in the list",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = utils.getInstance(this).getAlreadyReadBooks();

        boolean existsInAlreadyReadBooks=false;

        for(Book b:alreadyReadBooks){
            if(b.getId()==book.getId()){
                existsInAlreadyReadBooks=true;
            }
        }

        if(existsInAlreadyReadBooks){
            addToReadBtn.setEnabled(false);
        }
        else{
            addToReadBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(utils.getInstance(BookActivity.this).addToAlreadyReadBooks(book)){
                        Toast.makeText(BookActivity.this,"Book Added",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this,"The Book already exists in the list",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book book) {
        bookNameTxt.setText(book.getName());
        authorTxt.setText(book.getAuthor());
        noOfPagesTxt.setText(String.valueOf(book.getNo_of_pages()));
        descriptionTxt.setText(String.valueOf(book.getLongDesc()));
        Glide.with(this)
                .asBitmap().load(book.getImgUrl())
                .into(bookImage);

    }
    private void initViews() {
        addToFavouriteBtn=findViewById(R.id.addToFavouritesBtn);
        addToReadBtn=findViewById(R.id.addToReadBtn);
        addToCurrentlyReadingBtn=findViewById(R.id.addToCurrentlyReadingBtn);
        addToWishListBtn=findViewById(R.id.addToWishListBtn);

        bookNameTxt=findViewById(R.id.NameValueTxt);
        authorTxt=findViewById(R.id.AuthorValueTxt);
        noOfPagesTxt=findViewById(R.id.NoOfPagesValuesTxt);
        descriptionTxt=findViewById(R.id.LongDescriptionTxt);
        bookImage=findViewById(R.id.BookImg);
    }
}
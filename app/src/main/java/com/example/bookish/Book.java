package com.example.bookish;

public class Book {
    private int id;
    private String name;
    private String author;
    private int no_of_pages;
    private String imgUrl;
    private String longDesc;
    private String shortDesc;
    private Boolean isExpanded;

    public Book(int id, String name, String author, int no_of_pages, String imgUrl, String shortDesc,String longDesc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.no_of_pages = no_of_pages;
        this.imgUrl = imgUrl;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;

        isExpanded=false;
    }

    public Boolean getExpanded() {
        return isExpanded;
    }

    public void setExpanded(Boolean expanded) {
        isExpanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNo_of_pages() {
        return no_of_pages;
    }

    public void setNo_of_pages(int no_of_pages) {
        this.no_of_pages = no_of_pages;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", no_of_pages=" + no_of_pages +
                ", imgUrl='" + imgUrl + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                '}';
    }

    public boolean isExpanded() {
        return isExpanded;
    }
}

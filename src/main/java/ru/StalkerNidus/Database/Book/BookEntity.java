package ru.StalkerNidus.Database.Book;

import java.util.Date;
import java.util.Objects;

public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date createDate;
    private double rating;
    private int ageRating;

    public BookEntity(int id, String title, String author, int pages, Date createDate, double rating, int ageRating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.createDate = createDate;
        this.rating = rating;
        this.ageRating = ageRating;
    }

    public BookEntity(String title, String author, int pages, Date createDate, double rating, int ageRating) {
        this.id = -1;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.createDate = createDate;
        this.rating = rating;
        this.ageRating = ageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && pages == that.pages && Double.compare(that.rating, rating) == 0 && ageRating == that.ageRating && Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, pages, createDate, rating, ageRating);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", createDate=" + createDate +
                ", rating=" + rating +
                ", ageRating=" + ageRating +
                '}';
    }

    public int getId() {
        return id;
    }

    public BookEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public BookEntity setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public BookEntity setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public BookEntity setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public BookEntity setAgeRating(int ageRating) {
        this.ageRating = ageRating;
        return this;
    }
}

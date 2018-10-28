package pl.sda.bookscrud.domain.dto;

import pl.sda.bookscrud.domain.enums.Cover;

public class BookDTO extends BookMinDTO{
    private AuthorMinDTO author;
    private String genre;
    private Integer publishYear;

    public AuthorMinDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorMinDTO author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private Cover cover;
    private Integer price;
    private String language;
}

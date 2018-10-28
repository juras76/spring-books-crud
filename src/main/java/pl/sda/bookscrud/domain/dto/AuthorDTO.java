package pl.sda.bookscrud.domain.dto;

import pl.sda.bookscrud.domain.enums.Gender;

import java.util.List;

public final class AuthorDTO extends AuthorMinDTO {
    private Boolean alive;
    private Gender gender;

    private List<BookMinDTO> books;

    public List<BookMinDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookMinDTO> books) {
        this.books = books;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

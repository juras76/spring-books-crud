package pl.sda.bookscrud.domain.dto;

import pl.sda.bookscrud.domain.enums.Gender;

public final class AuthorDTO extends AuthorMinDTO {
    private Boolean alive;
    private Gender gender;

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

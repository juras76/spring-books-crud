package pl.sda.bookscrud.domain.dto;

public class BookMinDTO extends IdDTO {
    private String title;

    public BookMinDTO(Long id, String title) {
        super(id);
        this.title = title;
    }

    public BookMinDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

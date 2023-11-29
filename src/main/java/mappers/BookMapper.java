package mappers;

import entities.BookEntity;
import models.BookChangeStatusDto;
import models.BookDto;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
@Component
public class BookMapper {

    public BookEntity toEntity(BookDto from) {
        var to = new BookEntity();
        to.setId(from.getId());
        to.setTitle(from.getTitle());
        to.setAuthor(from.getAuthor());
        to.setGenre(from.getGenre());
        to.setPublicationDate(from.getPublicationDate());
        to.setPageCount(from.getPageCount());
        to.setAvailable(from.isAvailable());
        to.setCreatedAt(LocalDateTime.now());
        to.setCreatedBy("admin");
        return to;
    }

    public BookDto toDto(BookEntity from) {
        var to = new BookDto();
        to.setId(from.getId());
        to.setTitle(from.getTitle());
        to.setAuthor(from.getAuthor());
        to.setGenre(from.getGenre());
        to.setPublicationDate(from.getPublicationDate());
        to.setPageCount(from.getPageCount());
        to.setAvailable(from.isAvailable());
        return to;
    }

    public BookChangeStatusDto toChangeStatusDto(BookEntity from) {
        var to = new BookChangeStatusDto();
        to.setId(from.getId());
        to.setAvailable(from.isAvailable());
        return to;
    }
}
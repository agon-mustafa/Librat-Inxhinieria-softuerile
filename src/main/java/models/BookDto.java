package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long id;
    private String title;
    private String author;
    private String genre;
    private LocalDate publicationDate;
    private int pageCount;
    private boolean available = true;
}

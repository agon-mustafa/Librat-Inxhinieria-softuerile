package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "title", nullable = false, unique = true)
    private String title;

    private String author;
    private String genre;
    private LocalDate publicationDate;
    private int pageCount;
    private boolean available = true;
    private LocalDateTime createdAt;
    private String createdBy;
}

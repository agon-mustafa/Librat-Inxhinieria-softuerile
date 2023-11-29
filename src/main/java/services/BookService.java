package services;

import java.util.List;
import models.BookDto;
import models.BookChangeStatusDto;

public interface BookService {

    boolean add(BookDto bookDto);

    List<BookDto> getAll();

    BookDto getById(long id);

    boolean update(long id, BookDto updatedBookDto);

    boolean deleteById(long id);

    boolean changeStatus(long id, BookChangeStatusDto dto);
}
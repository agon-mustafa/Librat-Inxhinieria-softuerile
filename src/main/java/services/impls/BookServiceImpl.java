package services.impls;

import mappers.BookMapper;
import models.BookChangeStatusDto;
import models.BookDto;
import org.springframework.stereotype.Service;
import repositories.BookRepository;
import services.BookService;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookServiceImpl(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean add(BookDto bookDto) {
        var entity = mapper.toEntity(bookDto);
        repository.save(entity);
        return true;
    }

    @Override
    public List<BookDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookDto getById(long id) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new EntityNotFoundException("Book not found with id " + id);
        }
        return mapper.toDto(optionalEntity.get());
    }

    @Override
    public boolean update(long id, BookDto dto) {
        var optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new EntityNotFoundException("Book not found with id " + id);
        }

        var entity = optionalBook.get();
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setGenre(dto.getGenre());
        entity.setPublicationDate(dto.getPublicationDate());
        entity.setPageCount(dto.getPageCount());
        entity.setAvailable(dto.isAvailable());
        // Set other fields accordingly

        repository.save(entity);
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean changeStatus(long id, BookChangeStatusDto dto) {
        var optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new EntityNotFoundException("Book not found with id " + id);
        }

        var entity = optionalBook.get();
        entity.setAvailable(dto.isAvailable());

        repository.save(entity);
        return true;
    }
}
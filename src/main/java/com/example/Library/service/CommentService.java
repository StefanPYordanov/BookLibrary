package com.example.Library.service;

import com.example.Library.model.dto.CommentCreationDto;
import com.example.Library.model.dto.CommentViewDto;
import com.example.Library.model.entity.BookEntity;
import com.example.Library.model.entity.CommentEntity;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.CommentRepository;
import com.example.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public CommentService(BookRepository bookRepository, UserRepository userRepository,
                          CommentRepository commentRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }
    public List<CommentViewDto> getAllCommentsForBook(Long bookId) {
        BookEntity book = bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
        List<CommentEntity> comments = commentRepository.findAllByBook(book).get();
        return comments.stream().map(comment -> new CommentViewDto(comment.getId(), comment.getAuthor().getFullName(),
                comment.getText())).collect(Collectors.toList());
    }
    public CommentViewDto createComment(CommentCreationDto commentDto) {
        UserEntity author = userRepository.findUserEntityByUsername(commentDto.getUsername()).get();
        CommentEntity comment = new CommentEntity();
        comment.setCreated(LocalDateTime.now());
        comment.setBook(bookRepository.getById(commentDto.getRouteId()));
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setText(commentDto.getMessage());
        commentRepository.save(comment);
        return new CommentViewDto(comment.getId(), author.getFullName(), comment.getText());
    }
    public void deleteCommentsEveryYear() {
        commentRepository.deleteAll(commentRepository.findAll());
    }
}


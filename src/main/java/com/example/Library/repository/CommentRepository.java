package com.example.Library.repository;

import com.example.Library.model.entity.BookEntity;
import com.example.Library.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface CommentRepository extends JpaRepository <CommentEntity, Long> {
    Optional<List<CommentEntity>> findAllByBook(BookEntity book);
}

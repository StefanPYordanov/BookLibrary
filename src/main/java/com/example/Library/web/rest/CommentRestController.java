package com.example.Library.web.rest;

import com.example.Library.model.dto.CommentCreationDto;
import com.example.Library.model.dto.CommentMessageDto;
import com.example.Library.model.dto.CommentViewDto;
import com.example.Library.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {
    private CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{bookId}/comments")
    public ResponseEntity<List<CommentViewDto>> getComments(@PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok(commentService.getAllCommentsForBook(bookId));
    }

    @PostMapping(value = "/{bookId}/comments", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommentViewDto> createComment(@PathVariable("bookId") Long bookId,
                                                            @AuthenticationPrincipal UserDetails userDetails,
                                                            @RequestBody CommentMessageDto commentDto) {
        CommentCreationDto commentCreationDto = new CommentCreationDto(
                userDetails.getUsername(),
                bookId,
                commentDto.getMessage()
        );

        CommentViewDto comment = commentService.createComment(commentCreationDto);

        return ResponseEntity
                .created(URI.create(String.format("/api/%d/comments/%d", bookId, comment.getId())))
                .body(comment);
    }

}





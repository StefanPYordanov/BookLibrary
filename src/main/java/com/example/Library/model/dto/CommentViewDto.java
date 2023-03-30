package com.example.Library.model.dto;

public class CommentViewDto {
    private Long id;
    private String authorName;
    private String message;

    public CommentViewDto(Long id, String authorName, String message) {
        this.id = id;
        this.authorName = authorName;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public CommentViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public CommentViewDto setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommentViewDto setMessage(String message) {
        this.message = message;
        return this;
    }
}

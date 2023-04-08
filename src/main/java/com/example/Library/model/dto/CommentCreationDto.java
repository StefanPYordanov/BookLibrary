package com.example.Library.model.dto;

public class CommentCreationDto {
    private String username;
    private Long bookId;
    private String message;
    public CommentCreationDto(String username, Long bookId, String message) {
        this.username = username;
        this.bookId = bookId;
        this.message = message;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getRouteId() {
        return bookId;
    }
    public void setRouteId(Long routeId) {
        this.bookId = routeId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
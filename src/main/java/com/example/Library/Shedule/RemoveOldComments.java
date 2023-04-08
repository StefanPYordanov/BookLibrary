package com.example.Library.Shedule;

import com.example.Library.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class RemoveOldComments {
    private final CommentService commentService;
    @Autowired
    public RemoveOldComments(CommentService commentService) {
        this.commentService = commentService;
    }
    @Scheduled(cron = "0 0 1 1 *")
        public void deleteCommentsEveryYear(){
            this.commentService.deleteCommentsEveryYear();
        }
    }

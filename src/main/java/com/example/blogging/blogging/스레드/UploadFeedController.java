package com.example.blogging.blogging.스레드;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/feeds")
@RestController
public class UploadFeedController {

    private final UploadFeedService uploadFeedService;

    public UploadFeedController(UploadFeedService uploadFeedService) {
        this.uploadFeedService = uploadFeedService;
    }

    @PostMapping
    public ResponseEntity<Void> uploadFeed() {
        System.out.println("UploadFeedController.uploadFeed called");
        uploadFeedService.uploadProcess(new User(), new UploadFeedRequest());
        return ResponseEntity.ok().build();
    }
}

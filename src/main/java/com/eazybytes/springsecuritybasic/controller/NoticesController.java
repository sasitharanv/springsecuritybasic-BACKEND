package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.Repository.CustomerRepository;
import com.eazybytes.springsecuritybasic.Repository.NoticeRepository;
import com.eazybytes.springsecuritybasic.modal.Customer;
import com.eazybytes.springsecuritybasic.modal.Notice_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {
    private final NoticeRepository noticeRepository;


    @Autowired
    public NoticesController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/notices")
    public ResponseEntity<List<Notice_details>> getNotices() {
        List<Notice_details> notices=noticeRepository.findAll();
        if (!notices.isEmpty()) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            // Return a 404 Not Found response when no notices are found.
            return ResponseEntity.notFound().build();

        }
    }

}

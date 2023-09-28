package com.example.bank.controller;

import com.example.bank.model.Notice;
import com.example.bank.repository.NoticeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:37 AM
 */
@RestController
public class NoticeController {

    private NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null) {
            return notices;
        } else {
            return null;
        }
    }
}

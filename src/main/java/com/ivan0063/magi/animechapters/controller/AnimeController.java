package com.ivan0063.magi.animechapters.controller;

import com.ivan0063.magi.animechapters.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/anime")
public class AnimeController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping("/chapter/cannon/{chapterNo}")
    public ResponseEntity<Map> chapterIsCannot(@PathVariable("chapterNo") Integer chapterNo) throws Exception {
        return ResponseEntity.ok(chapterService.chapterIsCannon(chapterNo));
    }
}

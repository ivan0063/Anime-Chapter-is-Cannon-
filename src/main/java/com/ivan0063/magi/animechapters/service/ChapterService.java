package com.ivan0063.magi.animechapters.service;

import com.ivan0063.magi.animechapters.entity.Chapter;
import com.ivan0063.magi.animechapters.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public Map<String, Object> chapterIsCannon(Integer chapterNo) throws Exception {
        Chapter chapter = chapterRepository.findByChapterNoEquals(chapterNo)
                .orElseThrow(()->new Exception("I couldn't found the chapter on the DB"));
        String chapterStatus;
        Map<String, Object> chapterResponse = new HashMap<>();

        if (!chapter.getStatus().equals("RELLENO")) {
            chapterStatus = "Chapter is Cannon!";
        } else {
            Chapter chapterCannon = chapterRepository.findFirstByChapterNoGreaterThanAndStatusEquals(chapterNo, "CANON")
                    .orElseThrow(()->new Exception("I couldn't found the chapter on the DB"));
            chapterResponse.put("chapterCannon", chapterCannon);
            chapterStatus = "Chapter status is not cannon, go to " + chapterCannon.getChapterNo();
        }

        chapterResponse.put("status", chapterStatus);
        chapterResponse.put("chapterInformation", chapter);

        return chapterResponse;
    }
}

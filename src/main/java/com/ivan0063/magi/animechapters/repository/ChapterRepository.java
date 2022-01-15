package com.ivan0063.magi.animechapters.repository;

import com.ivan0063.magi.animechapters.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    Optional<Chapter> findByChapterNoEquals(Integer chapterNo);

    Optional<Chapter> findFirstByChapterNoGreaterThan(Integer chapterNo);

    Optional<Chapter> findFirstByChapterNoGreaterThanAndStatusEquals(Integer chapterNo, String status);
}

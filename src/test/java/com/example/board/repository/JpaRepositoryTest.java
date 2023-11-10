package com.example.board.repository;


import com.example.board.config.JpaConfig;
import com.example.board.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.*;

import java.util.List;


@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

//    @Test
//    void givenTestData_whenSelecting_thenWorksFine() {
//        // Given
//
//        // When
//        List<Article> articles = articleRepository.findAll();
//
//        // Then
//        assertThat(articles)
//                .isNotNull()
//                .hasSize(0);
//    }

    @Test
    void insertTest() {
        Article savedArticle = articleRepository.saveAndFlush(Article.of("new article", "new content", "#spring"));

        assertThat(articleRepository.count()).isEqualTo(1001);
    }
    @DisplayName("update테스트")
    @Test
    void givenTestDate_whenUpdating_thenWorksFine() {
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        Article savedArticle = articleRepository.save(article);

        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag );

    }
}
package com.example.board.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 게시글")
@AutoConfigureMockMvc
@SpringBootTest
class ArticleControllerTest {
    private final MockMvc mvc;

    ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    @DisplayName("[view] [GET] 게시글 리스트(게시판) 페이지 - 정상 호출")
    @Test
    public void givenNoting_whenRequestArticleView_thenReturnsArticles() throws Exception {
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));
    }

//    @DisplayName("[View] [GET] 게시글 검색 전용 페이지 - 정상 호출")
//    @Test
//    void name() {
//    }
}
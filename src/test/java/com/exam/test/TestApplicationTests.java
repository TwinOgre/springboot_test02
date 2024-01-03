package com.exam.test;

import com.exam.test.article.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {
	@Autowired
	ArticleService articleService;

	@Test
	void contextLoads() {
	}

	@Test
	void test13(){
		for (int i = 1; i <= 300; i++) {
			String title = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.articleService.create(title, content);
		}
	}

}

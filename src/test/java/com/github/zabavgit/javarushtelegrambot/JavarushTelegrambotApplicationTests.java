package com.github.zabavgit.javarushtelegrambot;

import com.github.zabavgit.javarushtelegrambot.bot.JavarushTelegrambotApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = JavarushTelegrambotApplication.class,
        properties = {"bot.token=mock_token_for_testing"}
)
class JavarushTelegrambotApplicationTests {

    @Test
    void contextLoads() {
    }

}

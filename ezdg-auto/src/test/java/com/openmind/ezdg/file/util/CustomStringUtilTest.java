package com.openmind.ezdg.file.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomStringUtilTest {

    @Autowired
    private CustomStringUtil customStringUtil;

    @Test
    void snakeCaseToCamelCase() {
        // given
        String snakeCase = "im_snake_case";
        String notSnakeCase = "im_Not_snake_Case";

        // when

        // then
        assertThat(customStringUtil.snakeCaseToCamelCase(snakeCase)).isEqualTo("imSnakeCase");
        Assertions.assertThatThrownBy(() -> customStringUtil.snakeCaseToCamelCase(notSnakeCase))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void isSnakeCase() {
        // given
        String snakeCase = "im_snake_case";
        String notSnakeCase = "im_Not_snake_Case";

        // when

        // then
        assertThat(customStringUtil.isSnakeCase(snakeCase)).isTrue();
        assertThat(customStringUtil.isSnakeCase(notSnakeCase)).isFalse();
    }
}
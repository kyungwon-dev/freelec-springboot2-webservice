package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 10000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        /*
         * assertThat
         * - assertj라는 테스트 검증 라이브러리의 검증 메소드.
         * - 검증하고 싶은 대상을 메소드 인자로 받습니다.
         * - 메소드 체이닝이 지원되어, isEqualTo와 같이 메소드를 이어서 사용.
         * isEqualTo
         * - assertj의 동등 비교 메소드 입니다.
         * - assertThat에 있는 값과 isEqualTo의 값을 비교하여 같을 때만 성공입니다.
         * Junit의 assertThat vs assertj의 asserThat 차이
         * - CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않습니다.
         * -- Junit의 assertThat을 쓰게 되면, is()와 같이 CoreMatchers 라이브러리가 필요합니다.
         *
         */

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}

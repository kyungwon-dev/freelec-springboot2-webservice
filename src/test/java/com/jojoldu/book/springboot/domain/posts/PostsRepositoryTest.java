package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정 없이 사용하면, 자동으로 H2 데이터베이스 실행.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    /*
     * After
     * - Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
     * - 보통은 배포 전 전체 테스트를 수행할 때 테스트 간 데이터 침범을 막기 위해 사용
     * - 여러 테스트가 동시에 수행되면 테스트용 데이터베이스은 H2에 데이터가 그대로 남아 있어, 문제 발생
     */
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        /*
         * postsRepository.save
         * - 테이블 posts에 insert/update 쿼리를 수행.
         * - id 값이 있다면 update, 없으면 insert
         */
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("kyungwon.dev@gmail.com")
                .build()
        );
        /*
         * postsRepository.findAll();
         * - 테이블 posts에 있는 모든 데이터를 조회해 오는 메소드
         */
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록된다(){
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate=" + posts.getCreateDate() + ", " + posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}

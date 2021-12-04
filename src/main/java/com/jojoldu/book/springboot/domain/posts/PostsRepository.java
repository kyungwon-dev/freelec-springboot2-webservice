package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*
     * 보통 Dao 라고 불리는 DB Layer입니다.
     * JPA에서는 Repository라고 불리며 인터페이스로 생성.
     * 인터페이스 생성 후, <Entity Class, PK Type> 을 상속하면 기본적인 CRUD가 자동으로 생성.
     * @Repository 를 추가할 필요 없음.
     * 다만 주의할 사항으로는 Entity 클래스와 기본 Entity Repository가 같은 경로 내에 존재.
     * Entity Class와 Repository는 하나의 묶음으로 관리하기.
     */

}

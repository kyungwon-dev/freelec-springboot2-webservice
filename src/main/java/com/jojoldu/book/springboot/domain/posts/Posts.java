package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// Annotation 순서는, 주요 클래스에 가깝게 둠

/*
 * Entity
 * - 테이블과 링크될 클래스
 * - 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭합니다.
 *   - SalesManager.java -> sales_manager table
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    /*
     * Id
     * - 해당 테이블의 PK 필드를 나타냅니다.
     * GeneratedValue
     * - PK의 생성 규칙을 나타냅니다.
     * - Springboot 2.0 에서는 GenerationType.IDENTITY 추가를 통해 auto_increment가 됩니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Column
     * - 테이블의 컬럼을 나타내며, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 됩니다.
     * - 다만, 기본값 외의 추가로 변경이 필요한 옵션이 있으면 사용.
     * - 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 늘리고 싶거나 타입을 TEXT로 변경 등의 이유로 사용
     */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
     * Builder
     * - 해당 클래스의 빌더 패턴 클래스를 생성.
     * - 생성자 상단에 선언 시 생성장에 포함된 필드만을 빌더에 포함.
     */
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content= content;
    }
}

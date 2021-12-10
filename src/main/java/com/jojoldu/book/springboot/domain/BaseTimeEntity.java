package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 * MapperdSupperclass
 * - JPA Entity zmffotmemfdl BaseTimeEntity을 상속할 경우 필드들도 컬럼으로 인식하도록 합니다.
 * - 여기서 필드들이란 createdDate, modifiedDate
 * EntityListeners
 * - BaseTimeEntity 클래스에 Auditing 기능을 포함시킵니다.
 * @CreateDate
 * - Entity 가 생성되어 저장될 때 시간이 자동 저장됩니다.
 * @LastModifiedDate
 * - 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}

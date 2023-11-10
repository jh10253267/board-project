package com.example.board.domain;


import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy; // 생성자

    @LastModifiedDate
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false)
    private LocalDateTime modifiedAt; // 변경일시

    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy; // 변경자
}

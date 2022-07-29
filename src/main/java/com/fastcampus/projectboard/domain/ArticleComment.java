package com.fastcampus.projectboard.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ArticleComment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)  //optional 필수값이다.
    private Article article; // 게시글 (ID)

    @Setter
    @Column(nullable = false, length = 255)
    private String content; // 본문

    private LocalDateTime createdAt; // 생성일시

    private String createdBy; // 생성자

    private LocalDateTime modifiedAt; // 수정일시

    private String modifiedBy; // 수정자
}

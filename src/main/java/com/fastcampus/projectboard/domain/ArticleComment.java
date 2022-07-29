package com.fastcampus.projectboard.domain;

import lombok.*;

import javax.persistence.*;

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
}

package diaryApplication.diary.domain.member;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String nickname;
    private Long categoryId; // 대표 캐릭터 아이디 값

    public void diaryMemberIdSet(Long id) {
        this.id = id;
    }
}

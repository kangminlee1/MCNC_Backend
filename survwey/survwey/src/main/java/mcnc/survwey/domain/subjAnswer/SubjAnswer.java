package mcnc.survwey.domain.subjAnswer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.question.Question;
import mcnc.survwey.domain.user.User;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subj_answer")
public class SubjAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long subjId;

    private LocalDateTime writtenDate;

    @Column(columnDefinition = "TEXT")
    private String response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quesId", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}

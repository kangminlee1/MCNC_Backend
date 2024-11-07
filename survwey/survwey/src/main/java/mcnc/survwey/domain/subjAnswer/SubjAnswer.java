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

    @Column(nullable = false)
    private LocalDateTime writtenDate;

    @Column(columnDefinition = "TEXT")
    private String response;

    @ManyToOne
    @JoinColumn(name = "quesId", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private User user;

}

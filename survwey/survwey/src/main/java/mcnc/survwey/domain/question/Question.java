package mcnc.survwey.domain.question;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.questionType.QuestionType;
import mcnc.survwey.domain.survey.Survey;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long quesId;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "surveyId", nullable = false)
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private QuestionType questionType;
    
}

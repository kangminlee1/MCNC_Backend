package mcnc.survwey.domain.respond;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.survey.Survey;
import mcnc.survwey.domain.user.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(
        name = "respond",
        uniqueConstraints = @UniqueConstraint(columnNames = {"surveyId", "userId"})
)
@Entity
public class Respond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long respondId;

    private LocalDateTime respondDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyId", nullable = false)
    private Survey survey;

}

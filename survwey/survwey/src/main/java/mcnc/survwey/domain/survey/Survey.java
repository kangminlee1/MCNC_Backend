package mcnc.survwey.domain.survey;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.user.User;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long surveyId;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime expireDate;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private User user;

}

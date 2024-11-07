package mcnc.survwey.domain.selection;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.question.Question;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "selection")
public class Selection {

    @EmbeddedId
    private SelectionId id;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "ques_id", insertable = false, updatable = false)
    private Question question;

}

package mcnc.survwey.api.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSurveyDTO {
    private String title;
    private String description;
    private String email;
    private LocalDateTime expireDate;
    private List<QuestionDTO> questionList;
}

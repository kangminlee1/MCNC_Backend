package mcnc.survwey.api.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.enums.QuestionType;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTO {
    private String body;
    private QuestionType type;
    private List<SelectionDTO> selectionList;
}

package mcnc.survwey.api.survey.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "질문 내용은 필수입니다.")
    private String body;

    private QuestionType type;

    private List<SelectionDTO> selectionList;
}

package mcnc.survwey.api.survey.dto;

import jakarta.validation.constraints.*;
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
    @NotBlank(message = "설문 제목은 필수입니다.")
    private String title;

    private String description;

    @Size(min = 5, max = 20, message = "사용자 아이디는 5글자 이상, 20글자 이하입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "사용자 아이디는 영문과 숫자의 조합이어야 합니다.")
    private String userId;

    @NotNull(message = "만료일 지정은 필수입니다.")
    private LocalDateTime expireDate;

    private List<QuestionDTO> questionList;
}

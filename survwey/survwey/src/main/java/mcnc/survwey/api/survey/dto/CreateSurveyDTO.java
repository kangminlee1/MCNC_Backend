package mcnc.survwey.api.survey.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    private String email;

    @NotNull(message = "만료일 지정은 필수입니다.")
    private LocalDateTime expireDate;

    private List<QuestionDTO> questionList;
}

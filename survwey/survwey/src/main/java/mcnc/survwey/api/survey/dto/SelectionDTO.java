package mcnc.survwey.api.survey.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SelectionDTO {
    @NotBlank(message = "보기 내용은 필수입니다.")
    private String body;
}

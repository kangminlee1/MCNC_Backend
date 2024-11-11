package mcnc.survwey.api.survey.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchDTO {

    private String title;
    @NotBlank(message = "아이디는 필수입니다.")
    @Email(message = "유효한 아이디를 입력해주세요.")
    private String userId;

}

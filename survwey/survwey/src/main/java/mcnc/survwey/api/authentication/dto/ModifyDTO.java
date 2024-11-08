package mcnc.survwey.api.authentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.enums.Gender;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ModifyDTO {

    @NotBlank(message = "이메일은 필수입니다.")
    private String email;

    @NotNull(message = "생년월일은 필수입니다.")
//    @Pattern(
//            regexp = "^\\d{4}-\\d{2}-\\d{2}$",
//            message = "생년월일은 yyyy-MM-dd 형식이어야 합니다.")front랑 맞추자
    private LocalDate birth;

    @NotNull(message = "성별은 필수입니다.")
//    @Pattern(
//            regexp = "^[MF]$\n",
//            message = "성별은 M, F만 포함해야 합니다."
//    )
    private Gender gender;

    @NotBlank(message = "이름은 필수입니다.")
    private String name;
}

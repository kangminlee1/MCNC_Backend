package mcnc.survwey.api.authentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import mcnc.survwey.domain.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AuthDTO {

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+]).{8,}$",
            message = "비밀번호는 최소 8자, 숫자, 특수문자 및 대소문자를 포함해야 합니다."
    )
    private String password;

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

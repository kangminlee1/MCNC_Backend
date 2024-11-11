package mcnc.survwey.api.authentication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.authentication.dto.AuthDTO;
import mcnc.survwey.api.authentication.dto.ChangePasswordDTO;
import mcnc.survwey.api.authentication.dto.ModifyDTO;
import mcnc.survwey.domain.user.User;
import mcnc.survwey.domain.user.UserRepository;
import mcnc.survwey.global.exception.custom.CustomException;
import mcnc.survwey.global.exception.custom.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입 메서드
     *
     * @param authDTO
     */

    public void registerUser(AuthDTO authDTO) {
        if(userRepository.existsById(authDTO.getUserId())){//해당 아이디 이미 존재
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.USER_ID_ALREADY_EXISTS);
        }

        if (userRepository.existsById(authDTO.getEmail())) {//해당 이메일 존재
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.USER_EMAIL_ALREADY_EXISTS);
        }
        userRepository.save(User.builder()
                .userId(authDTO.getUserId())
                .email(authDTO.getEmail())
                .password(passwordEncoder.encode(authDTO.getPassword()))
                .name(authDTO.getName())
                .registerDate(LocalDateTime.now())
                .birth(authDTO.getBirth())
                .gender(authDTO.getGender())
                .build()
        );
    }

    /**
     * 프로필 수정
     * @param modifyDTO
     */
    public void modifyUser(ModifyDTO modifyDTO){

        User user = userRepository.findById(modifyDTO.getUserId())
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.USER_NOT_FOUND_BY_ID));

        if(modifyDTO.getName().isEmpty() || modifyDTO.getName().isBlank()){
            modifyDTO.setName(user.getName());
        }
        if(modifyDTO.getGender().getValue().isEmpty() || modifyDTO.getGender().getValue().isBlank()){
            modifyDTO.setGender(user.getGender());
        }
        if(modifyDTO.getBirth() == null){
            modifyDTO.setBirth(user.getBirth());
        }
        user.setName(modifyDTO.getName());
        user.setGender(modifyDTO.getGender());
        user.setBirth(modifyDTO.getBirth());

        userRepository.save(user);
    }


    /**
     * 비밀번호 변경
     * @param changePasswordDTO
     */
    public void changePassword(ChangePasswordDTO changePasswordDTO){
        User user = userRepository.findById(changePasswordDTO.getUserId())
                .orElseThrow(() ->
                        new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.USER_NOT_FOUND_BY_ID));

        user.setPassword(passwordEncoder.encode(changePasswordDTO.getPassword()));

        userRepository.save(user);
    }

}

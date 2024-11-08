package mcnc.survwey.api.authentication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.authentication.dto.AuthDTO;
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
        if (userRepository.existsById(authDTO.getEmail())) {//해당 이메일 존재
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.USER_ALREADY_EXISTS);
        }
        userRepository.save(User.builder()
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

        User user = userRepository.findById(modifyDTO.getEmail())
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.USER_ALREADY_EXISTS));

        user.setName(modifyDTO.getName());
        user.setGender(modifyDTO.getGender());
        user.setBirth(modifyDTO.getBirth());

        userRepository.save(user);
    }


}

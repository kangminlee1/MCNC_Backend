package mcnc.survwey.api.authentication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.authentication.dto.AuthDTO;
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
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입 메서드
     *
     * @param authDTO
     */
    @Transactional
    public void registerUser(AuthDTO authDTO) {
        if (userRepository.existsById(authDTO.getEmail())) {
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

}

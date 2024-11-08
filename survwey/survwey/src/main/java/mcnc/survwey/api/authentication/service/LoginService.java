package mcnc.survwey.api.authentication.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.authentication.dto.LoginDTO;
import mcnc.survwey.domain.user.User;
import mcnc.survwey.domain.user.UserService;
import mcnc.survwey.global.exception.custom.CustomException;
import mcnc.survwey.global.exception.custom.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static mcnc.survwey.global.config.SessionConst.LOGIN_USER;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public boolean loginAndCreateSession(LoginDTO loginDTO, HttpServletRequest request) {
        User foundUser = userService.findByEmail(loginDTO.getEmail());
        if (passwordEncoder.matches(loginDTO.getPassword(), foundUser.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute(LOGIN_USER, loginDTO.getEmail());
            return true;
        } else {
            throw new CustomException(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_PASSWORD);
        }
    }
}

package mcnc.survwey.api.authentication.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.authentication.dto.LoginDTO;
import mcnc.survwey.api.authentication.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody @Valid LoginDTO loginDTO, HttpServletRequest request) {
        boolean loginResult = loginService.loginAndCreateSession(loginDTO, request);
        if (loginResult) {
            return ResponseEntity.ok(Collections.singletonMap("userId", loginDTO.getUserId()));
        }
        return ResponseEntity.badRequest().body(null);
    }
}

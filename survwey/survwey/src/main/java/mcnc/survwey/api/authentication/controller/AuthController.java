package mcnc.survwey.api.authentication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mcnc.survwey.api.authentication.dto.AuthDTO;
import mcnc.survwey.api.authentication.dto.ModifyDTO;
import mcnc.survwey.api.authentication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<Object> register(@Valid @RequestBody AuthDTO authDTO) {
        authService.registerUser(authDTO);
        return ResponseEntity.ok(authDTO.getEmail());
    }

    @PostMapping("/modify")
    public ResponseEntity<Object> modify(@Valid @RequestBody ModifyDTO modifyDTO){

        authService.modifyUser(modifyDTO);

        return ResponseEntity.ok(modifyDTO.getEmail());
    }

}

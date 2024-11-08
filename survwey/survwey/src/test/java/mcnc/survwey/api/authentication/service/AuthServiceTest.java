package mcnc.survwey.api.authentication.service;

import mcnc.survwey.api.authentication.dto.AuthDTO;
import mcnc.survwey.api.authentication.dto.ModifyDTO;
import mcnc.survwey.domain.enums.Gender;
import mcnc.survwey.domain.user.User;
import mcnc.survwey.domain.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUser(){

        AuthDTO authDTO = new AuthDTO();

        authDTO.setEmail("asd@asdasd.com123");
        authDTO.setPassword("qwer1234@@");
        authDTO.setName("tester");
        authDTO.setBirth(LocalDate.now());
        authDTO.setGender(Gender.M);

        authService.registerUser(authDTO);
        User user = userRepository.findById(authDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("user.getEmail() = " + user.getEmail());

        assertThat(user.getEmail()).isEqualTo("asd@asdasd.com123");

    }

    @Test
    public void modifyUser(){


        ModifyDTO modifyDTO = new ModifyDTO();

        modifyDTO.setEmail("asd@asdasd.com12");
        modifyDTO.setName("modifyTest");
        modifyDTO.setBirth(LocalDate.now());
        modifyDTO.setGender(Gender.M);

        authService.modifyUser(modifyDTO);

        User user = userRepository.findById(modifyDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User가 존재하지 않습니다."));

        assertThat(user.getName()).isEqualTo(modifyDTO.getName());
        assertThat(user.getGender()).isEqualTo(modifyDTO.getGender());
        assertThat(user.getBirth()).isEqualTo(modifyDTO.getBirth());

    }

}
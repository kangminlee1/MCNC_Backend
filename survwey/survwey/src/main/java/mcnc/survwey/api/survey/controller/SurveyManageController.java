package mcnc.survwey.api.survey.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.dto.CreateSurveyDTO;
import mcnc.survwey.api.survey.service.SurveyManageService;
import mcnc.survwey.domain.survey.Survey;
import mcnc.survwey.global.config.SessionContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
public class SurveyManageController {

    private final SurveyManageService surveyManageService;

    @PostMapping("/create")
    public ResponseEntity<Object> createSurvey(@Valid @RequestBody CreateSurveyDTO createSurveyDTO) {
        try {
            String userId = SessionContext.getCurrentUser();
            Survey survey = surveyManageService.createSurveyWithDetails(createSurveyDTO, userId);
            return ResponseEntity.ok().body(survey);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

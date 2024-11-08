package mcnc.survwey.api.survey.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.dto.CreateSurveyDTO;
import mcnc.survwey.api.survey.service.SurveyManageService;
import mcnc.survwey.domain.survey.Survey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
public class SurveyManageController {

    private final SurveyManageService surveyManageService;

    @PostMapping("/create")
    public ResponseEntity<Object> createSurvey(@RequestBody CreateSurveyDTO createSurveyDTO) {
        try{
            Survey survey = surveyManageService.createSurveyWithDetails(createSurveyDTO);
            return ResponseEntity.ok().body(survey);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

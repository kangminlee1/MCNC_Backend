package mcnc.survwey.api.survey.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.dto.CreateSurveyDTO;
import mcnc.survwey.api.survey.service.SurveyModifyService;
import mcnc.survwey.domain.survey.Survey;
import mcnc.survwey.global.config.SessionContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/survey")
public class SurveyModifyController {

    private final SurveyModifyService surveyModifyService;


    public ResponseEntity<Object> surveyModify (@Valid @RequestBody CreateSurveyDTO createSurveyDTO, @PathVariable Long surveyId){
        String userId = SessionContext.getCurrentUser();
        Survey survey = surveyModifyService.surveyModifyWithDetails(createSurveyDTO, surveyId, userId);

        return ResponseEntity.ok().body(survey);
    }

}

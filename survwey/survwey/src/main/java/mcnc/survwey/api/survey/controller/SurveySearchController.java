package mcnc.survwey.api.survey.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.service.SurveySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("survey/")
public class SurveySearchController {

    @Autowired
    private final SurveySearchService surveySearchService;

    @PostMapping("/search")
    public ResponseEntity<Object> surveySearch(String title){
        return ResponseEntity.ok(Collections.singletonMap("surveyList", surveySearchService.surveySearch(title)));
    }
}

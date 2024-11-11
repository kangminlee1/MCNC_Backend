package mcnc.survwey.api.survey.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.dto.CreateSurveyDTO;
import mcnc.survwey.domain.question.Question;
import mcnc.survwey.domain.question.QuestionService;
import mcnc.survwey.domain.selection.SelectionService;
import mcnc.survwey.domain.survey.Survey;
import mcnc.survwey.domain.survey.SurveyService;
import mcnc.survwey.domain.user.User;
import mcnc.survwey.domain.user.UserService;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class SurveyManageService {

    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final SelectionService selectionService;
    private final UserService userService;

    @Transactional
    public Survey createSurveyWithDetails(CreateSurveyDTO createSurveyDTO) {
        User creator = userService.findByUserId(createSurveyDTO.getUserId());
        Survey createdSurvey = surveyService.initializeSurvey(createSurveyDTO, creator);
        createSurveyDTO.getQuestionList()
                .forEach(questionDTO -> {
                    Question createdQuestion = questionService.buildAndSaveQuestion(questionDTO, createdSurvey);
                    selectionService.addSelectionsToQuestion(createdQuestion, questionDTO.getSelectionList());
                });
        return createdSurvey;
    }

}

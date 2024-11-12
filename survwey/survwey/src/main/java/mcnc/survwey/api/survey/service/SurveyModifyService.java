package mcnc.survwey.api.survey.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.dto.CreateSurveyDTO;
import mcnc.survwey.domain.question.Question;
import mcnc.survwey.domain.question.QuestionService;
import mcnc.survwey.domain.respond.Respond;
import mcnc.survwey.domain.respond.RespondService;
import mcnc.survwey.domain.selection.SelectionService;
import mcnc.survwey.domain.survey.Survey;
import mcnc.survwey.domain.survey.SurveyRepository;
import mcnc.survwey.domain.survey.SurveyService;
import mcnc.survwey.domain.user.User;
import mcnc.survwey.domain.user.UserRepository;
import mcnc.survwey.domain.user.UserService;
import mcnc.survwey.global.exception.custom.CustomException;
import mcnc.survwey.global.exception.custom.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SurveyModifyService {

    private final UserService userService;
    private final SelectionService selectionService;
    private final QuestionService questionService;
    private final SurveyService surveyService;
    private final RespondService respondService;

    @Transactional
    public Survey surveyModifyWithDetails(CreateSurveyDTO createSurveyDTO, Long surveyId, String userId) {

        User updater = userService.findByUserId(userId);

        Respond respond = respondService.respondExist(surveyId);
        //답안이 작성이 되었는가 확인

        Survey updatedSurvey = surveyService.initializeSurvey(createSurveyDTO, updater);
        createSurveyDTO.getQuestionList()
                .forEach(questionDTO -> {
                    Question updatedQuestion = questionService.buildAndSaveQuestion(questionDTO, updatedSurvey);
                    selectionService.addSelectionsToQuestion(updatedQuestion, questionDTO.getSelectionList());
                });

        return updatedSurvey;
    }

}

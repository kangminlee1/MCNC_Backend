package mcnc.survwey.api.survey.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcnc.survwey.api.survey.dto.SearchDTO;
import mcnc.survwey.domain.survey.Survey;
import mcnc.survwey.domain.survey.SurveyRepository;
import mcnc.survwey.domain.survey.SurveyService;
import mcnc.survwey.domain.user.User;
import mcnc.survwey.domain.user.UserRepository;
import mcnc.survwey.domain.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SurveySearchService {


    private final SurveyRepository surveyRepository;
    private final UserService userService;

    /**
     * 설문 제목 검색
     * @param title
     * @return
     */
    public List<Survey> surveySearch(String title){
        List<Survey> surveys = surveyRepository.findByTitleContaining(title);

        return surveys.isEmpty() ? null : surveys;
    }

}

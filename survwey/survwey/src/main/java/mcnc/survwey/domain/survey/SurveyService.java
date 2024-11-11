package mcnc.survwey.domain.survey;

import lombok.RequiredArgsConstructor;
import mcnc.survwey.api.survey.dto.CreateSurveyDTO;
import mcnc.survwey.domain.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public Survey initializeSurvey(CreateSurveyDTO createSurveyDTO, User creator) {
        Survey createdSurvey = Survey.builder()
                .title(createSurveyDTO.getTitle())
                .expireDate(createSurveyDTO.getExpireDate())
                .description(createSurveyDTO.getDescription())
                .user(creator)
                .createDate(LocalDateTime.now())
                .build();
        surveyRepository.save(createdSurvey);
        return createdSurvey;
    }

    public boolean deleteSurveyById(Long surveyId) {
        if (surveyRepository.existsById(surveyId)) {
            surveyRepository.deleteById(surveyId);
            return true;
        } else {
            return false;
        }
    }
}

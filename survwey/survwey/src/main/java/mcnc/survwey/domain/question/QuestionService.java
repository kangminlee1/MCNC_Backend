package mcnc.survwey.domain.question;

import lombok.RequiredArgsConstructor;
import mcnc.survwey.api.survey.dto.QuestionDTO;
import mcnc.survwey.domain.enums.QuestionType;
import mcnc.survwey.domain.survey.Survey;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question buildAndSaveQuestion(QuestionDTO questionDTO, Survey createdSurvey) {
        Question createdQuestion = Question.builder()
                .body(questionDTO.getBody())
                .type(questionDTO.getType())
                .survey(createdSurvey)
                .build();
        questionRepository.save(createdQuestion);
        return createdQuestion;
    }
}

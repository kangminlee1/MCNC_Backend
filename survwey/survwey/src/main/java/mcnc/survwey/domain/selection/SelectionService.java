package mcnc.survwey.domain.selection;

import lombok.RequiredArgsConstructor;
import mcnc.survwey.api.survey.dto.SelectionDTO;
import mcnc.survwey.domain.question.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectionService {
    private final SelectionRepository selectionRepository;

    public void addSelectionsToQuestion(Question createdQuestion, List<SelectionDTO> selectionDTOList) {
        List<Selection> selectionList = selectionDTOList.stream()
                .map(selectionDTO -> buildSelection(createdQuestion, selectionDTOList.indexOf(selectionDTO), selectionDTO))
                .toList();
        selectionRepository.saveAll(selectionList);
    }

    private Selection buildSelection(Question createdQuestion, int sequence, SelectionDTO selectionDTO) {
        SelectionId selectionId = new SelectionId(createdQuestion.getQuesId(), sequence + 1);
        return Selection.builder()
                .id(selectionId)
                .body(selectionDTO.getBody())
                .question(createdQuestion)
                .build();
    }
}

package mcnc.survwey.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionType {
    SUBJ("주관식"),
    OBJ("객관식");

    private final String value;
}
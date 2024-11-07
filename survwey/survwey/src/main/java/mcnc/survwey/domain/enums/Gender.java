package mcnc.survwey.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    M("MALE"),
    F("FEMALE");

    private final String value;
}


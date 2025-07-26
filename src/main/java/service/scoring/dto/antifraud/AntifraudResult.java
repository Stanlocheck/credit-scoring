package service.scoring.dto.antifraud;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AntifraudResult {
    private Boolean isFraud;
    private String firstName;
    private String secondName;
    private Boolean isBlackList;
    private Integer fraudScore;
}

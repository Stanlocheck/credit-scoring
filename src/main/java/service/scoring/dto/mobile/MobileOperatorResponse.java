package service.scoring.dto.mobile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobileOperatorResponse {
    private String operatorName;
    private Integer score;
}

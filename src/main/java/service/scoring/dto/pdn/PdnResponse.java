package service.scoring.dto.pdn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdnResponse {
    private Double pdnValue;
    private Boolean isRisk;
}

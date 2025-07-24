package service.scoring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import service.scoring.dto.antifraud.AntifraudResult;
import service.scoring.dto.bki.BkiResult;
import service.scoring.dto.fssp.FsspCheckResponse;
import service.scoring.dto.mobile.MobileOperatorResponse;
import service.scoring.dto.pdn.PdnResponse;

@Getter
@Setter
@AllArgsConstructor
public class ScoringInfo {
    private Long creditId;
    private AntifraudResult antifraudResult;
    private BkiResult bkiResult;
    private FsspCheckResponse fsspCheckResponse;
    private MobileOperatorResponse mobileOperatorResponse;
    private PdnResponse pdnResponse;
}

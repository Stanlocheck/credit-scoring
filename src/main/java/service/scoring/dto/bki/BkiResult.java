package service.scoring.dto.bki;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BkiResult {
    
    private Boolean hasOverstays;
    private Boolean hasOpenLoans;
    private List<Loan> loans;

    @Getter
    @Setter
    private static class Loan {
        private Integer creditAmount;
        private Boolean isClosed;
        private String type;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer percent;
        private Integer payment;
    }
}

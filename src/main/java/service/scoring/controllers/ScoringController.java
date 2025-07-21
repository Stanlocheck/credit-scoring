package service.scoring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.scoring.dto.CreditRequest;
import service.scoring.services.ScoringService;

@RestController
@RequestMapping("/api/scoring")
public class ScoringController {

    private final ScoringService scoringService;

    public ScoringController(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    @PostMapping("/score")
    public ResponseEntity<?> calculateScore(@RequestBody CreditRequest creditRequest) {
        scoringService.fullScoring(creditRequest);
        return ResponseEntity.ok().build();
    }
}

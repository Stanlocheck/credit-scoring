package service.scoring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<?> calculateScore(@RequestParam Long id) {
        scoringService.fullScoring(id);
        return ResponseEntity.ok().build();
    }
}

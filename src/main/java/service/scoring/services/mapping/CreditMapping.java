package service.scoring.services.mapping;

import org.springframework.stereotype.Service;
import service.scoring.dto.CreditRequest;
import service.scoring.dto.UserInfo;
import service.scoring.entities.Credit;

@Service
public class CreditMapping {

    public CreditRequest toDto(Credit credit){

        CreditRequest creditRequest = new CreditRequest();

        creditRequest.setCreditAmount(credit.getCreditAmount());
        creditRequest.setType(credit.getType());
        creditRequest.setPayment(credit.getPayment());
        creditRequest.setPercent(credit.getPercent());
        creditRequest.setStartDate(credit.getStartDate());
        creditRequest.setEndDate(credit.getEndDate());

        return creditRequest;
    }
}

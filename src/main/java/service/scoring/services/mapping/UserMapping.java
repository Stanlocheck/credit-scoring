package service.scoring.services.mapping;

import org.springframework.stereotype.Service;
import service.scoring.dto.CreditRequest;
import service.scoring.dto.UserInfo;
import service.scoring.entities.Credit;
import service.scoring.entities.User;

@Service
public class UserMapping {
    public UserInfo toDto(User user){

        UserInfo userInfo = new UserInfo();

        userInfo.setFirstName(user.getFirstName());
        userInfo.setSecondName(user.getSecondName());
        userInfo.setThirdName(user.getThirdName());
        userInfo.setCity(user.getCity());
        userInfo.setCountry(user.getCountry());
        userInfo.setPhoneNumber(user.getPhoneNumber());

        UserInfo.Passport passport = new UserInfo.Passport();
        passport.setSeriesPassport(user.getSeriesPassport());
        passport.setNumberPassport(user.getNumberPassport());
        passport.setIssuedBy(user.getIssuedBy());
        passport.setExpirationDate(user.getExpirationDate());
        passport.setIssuedDate(user.getIssuedDate());
        passport.setSex(user.getSex());
        passport.setBirthDate(user.getBirthDate());
        passport.setDepartmentCode(user.getDepartmentCode());
        userInfo.setPassport(passport);

        UserInfo.EmployeeInfo employeeInfo = new UserInfo.EmployeeInfo();
        employeeInfo.setCompanyName(user.getCompanyName());
        employeeInfo.setSalary(user.getSalary());
        employeeInfo.setStartDate(user.getStartDate());
        employeeInfo.setInn(user.getInn());
        userInfo.setEmployeeInfo(employeeInfo);

        return userInfo;
    }
}

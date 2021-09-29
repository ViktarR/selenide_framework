package pojo;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInformation {
    private String lastName = "Ivanov";
    private String firstName = "Ivan";
    private LocalDate birthDay = LocalDate.parse("1990-06-12");
    private Gender gender = Gender.MALE;
    private String citizenship = "Belarus";
    private String passportNumber = "123321";
    private LocalDate passportExpiryDate = LocalDate.parse("2025-06-12");

    @Override
    public String toString() {
        return "PersonInformation{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                ", citizenship='" + citizenship + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportExpiryDate=" + passportExpiryDate +
                '}';
    }
}


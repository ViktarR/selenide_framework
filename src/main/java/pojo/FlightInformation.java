package pojo;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightInformation {
    private String departureCountry = "Киев";
    private String arrivalCountry = "Мадрид";
    private String departureDate = "first enabled";
    private String returnDate = "next enabled";
    private int adultsCount = 1;
    private int childrenCount = 0;
    private int babiesCount = 0;

    @Override
    public String toString() {
        return "FlightInformation{" +
                "departureCountry='" + departureCountry + '\'' +
                ", arrivalCountry='" + arrivalCountry + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", adultsCount=" + adultsCount +
                ", childrenCount=" + childrenCount +
                ", babiesCount=" + babiesCount +
                '}';
    }
}

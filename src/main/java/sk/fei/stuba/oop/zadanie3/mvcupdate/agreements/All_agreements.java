package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements.LifeInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements.TravelInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements.HomeInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements.HouseAndFlatInsurance;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class All_agreements {
    protected Map<Integer, LifeInsurance> lifeAgreements;
    protected Map<Integer, TravelInsurance> travelAgreements;
    protected Map<Integer, HomeInsurance> homeAgreements;
    protected Map<Integer, HouseAndFlatInsurance> houseAgreements;
}

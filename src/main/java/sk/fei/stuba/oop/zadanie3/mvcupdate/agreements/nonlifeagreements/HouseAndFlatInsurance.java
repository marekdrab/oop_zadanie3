package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseAndFlatInsurance extends NonLifeAgreement{
    protected boolean garage_insurance;
}

package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeInsurance extends NonLifeAgreement{
    @Min(0)
    protected long furniture_value;
}

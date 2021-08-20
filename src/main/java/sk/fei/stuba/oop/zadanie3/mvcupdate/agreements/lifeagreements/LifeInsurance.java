package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.fei.stuba.oop.zadanie3.mvcupdate.enums.TerritorialValidity;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.Basic_agreement;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LifeInsurance extends Basic_agreement {
    @Min(0)
    protected int insuredid;
    @Min(0)
    protected long permanent_consequences;
    @Min(0)
    protected long death_case;
    @Min(0)
    protected long daily_payment;
    protected TerritorialValidity territorialValidity;
}

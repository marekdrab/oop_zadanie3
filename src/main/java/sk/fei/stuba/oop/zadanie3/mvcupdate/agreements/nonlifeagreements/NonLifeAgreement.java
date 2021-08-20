package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements;

import lombok.Data;
import sk.fei.stuba.oop.zadanie3.mvcupdate.enums.Real_estate_type;
import sk.fei.stuba.oop.zadanie3.mvcupdate.support.Address;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.Basic_agreement;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public abstract class NonLifeAgreement extends Basic_agreement {
    protected Real_estate_type real_estate_type;
    @NotNull
    protected Address address;
    @Min(0)
    protected long value;
}

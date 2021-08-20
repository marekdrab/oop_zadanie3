package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.Basic_agreement;
import sk.fei.stuba.oop.zadanie3.mvcupdate.enums.Destination;
import sk.fei.stuba.oop.zadanie3.mvcupdate.enums.Reason_of_traveling;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelInsurance extends Basic_agreement {
    @Min(0)
    protected int insuredid;
    protected Destination destination;
    protected Reason_of_traveling reason_of_traveling;
}

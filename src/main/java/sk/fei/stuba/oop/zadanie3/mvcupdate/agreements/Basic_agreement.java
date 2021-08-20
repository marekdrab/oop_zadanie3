package sk.fei.stuba.oop.zadanie3.mvcupdate.agreements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.fei.stuba.oop.zadanie3.mvcupdate.support.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Basic_agreement extends Entity {
    @NotNull
    @PastOrPresent
    protected LocalDate sign_date;
    @NotNull
    protected LocalDate start_date;
    @NotNull
    protected LocalDate end_date;
    @NotNull
    protected int insurerId;
    @Min(0)
    protected long amount;
    @Min(0)
    protected long month_payment;
}

package sk.fei.stuba.oop.zadanie3.mvcupdate.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.fei.stuba.oop.zadanie3.mvcupdate.support.Address;
import sk.fei.stuba.oop.zadanie3.mvcupdate.support.Entity;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.Basic_agreement;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Entity {
   @NotEmpty
    protected String first_name;
    @NotEmpty
    protected String last_name;
    @NotNull
    @Min(0)
    protected long ssid;
    @NotEmpty
    @Email
    protected String email;
    @NotNull
    protected Address permanent_address;
    @NotNull
    protected Address mailing_address;
    protected Set<Basic_agreement> agreements;

    public void setAgreements(Basic_agreement agreement) {
        this.agreements.add(agreement);
    }
}
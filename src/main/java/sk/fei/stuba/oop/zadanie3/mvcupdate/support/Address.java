package sk.fei.stuba.oop.zadanie3.mvcupdate.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NotNull
    protected String post_code;
    @NotNull
    protected String city;
    @NotNull
    protected String street;
    @NotNull
    protected String house_number;
}

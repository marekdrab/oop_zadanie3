package sk.fei.stuba.oop.zadanie3.mvcupdate.support;

import lombok.Data;
import sk.fei.stuba.oop.zadanie3.mvcupdate.support.IdGenerator;

@Data
public abstract class Entity {
    protected int id;

    public Entity() {
        this.id = IdGenerator.newId();
    }
}

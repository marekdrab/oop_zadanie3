package sk.fei.stuba.oop.zadanie3.mvcupdate.support;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


public class IdGenerator {
    private static final AtomicInteger generator = new AtomicInteger(0);

    public static int newId() {
        return generator.getAndIncrement();
    }
}

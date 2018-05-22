package it.eng.smartconveyor.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ascatox
 */
public class Constants {

    @Value("${conveyor.clock}")
    private int clock;

    public int getClock() {
        return clock;
    }

}

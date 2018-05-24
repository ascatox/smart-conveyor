package it.eng.smartconveyor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ascatox
 */
@Component
public class Constants {

    @Value("${slotList.size}")
    int size;

    public int getSize() {
        return size;
    }
}

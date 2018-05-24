package it.eng.smartconveyor;

import it.eng.smartconveyor.exception.ConveyorHubException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@ComponentScan
public class SmartConveyorApplication {

    public static void main(String[] args) throws ConveyorHubException {
        SpringApplication.run(SmartConveyorApplication.class, args);
    }




}

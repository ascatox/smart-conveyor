package it.eng.smartconveyor;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.exception.ConveyorHubException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartConveyorApplication {

	public static void main(String[] args) throws ConveyorHubException {
		SpringApplication.run(SmartConveyorApplication.class, args);
		Simulator simulator = new Simulator();
		simulator.simulate();
	}
}

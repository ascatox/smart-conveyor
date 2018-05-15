package it.eng.smartconveyor;

import it.eng.smartconveyor.base.Simulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartConveyorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartConveyorApplication.class, args);
		Simulator simulator = new Simulator();
		simulator.simulate();
	}
}

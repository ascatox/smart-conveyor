package it.eng.smartconveyor.config;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.tool.XMLReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ascatox
 */
@Configuration
public class ConfigConveyor {

    @Bean
    public Constants createConstants(){
        return new Constants();
    }

    @Bean
    public XMLReader createXmlReader() {
        return new XMLReader();
    }

    @Bean
    public Simulator createSimulator() throws ConveyorHubException {
        Simulator simulator = new Simulator();
        simulator.simulate();
        return simulator;
    }


}

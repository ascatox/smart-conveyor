package it.eng.smartconveyor.config;

import it.eng.smartconveyor.base.Simulator;
import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.helper.HandlerHelper;
import it.eng.smartconveyor.helper.SlotHelper;
import it.eng.smartconveyor.helper.SegmentHelper;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.tool.XMLReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ascatox
 */
@Configuration
public class InitApplication {

    @Bean
    public Constants createConstants() {
        return new Constants();
    }

    @Bean
    public XMLReader createXmlReader() {
        return new XMLReader();
    }

    private Conveyor conveyor;

    @Bean
    public SegmentHelper createSegmentHelper() {
        return new SegmentHelper();
    }

    @Bean
    public SlotHelper createNodeHelper() {
        return new SlotHelper();
    }

    @Bean
    public HandlerHelper createHandlerHelper() {
        return new HandlerHelper();
    }

    @Bean
    public Conveyor initConveyor() {
        return new Conveyor();
    }

    @Bean
    public Simulator createSimulator() throws ConveyorHubException {
        Simulator simulator = new Simulator();
        simulator.simulate();
        return simulator;
    }


}

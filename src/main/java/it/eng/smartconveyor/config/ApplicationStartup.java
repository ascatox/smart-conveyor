package it.eng.smartconveyor.config;

/**
 * @author ascatox
 */

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.model.Conveyor;
import it.eng.smartconveyor.simulate.Simulator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup
        implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * This method is called during Spring's startup.
     *
     * @param event Event raised when an ApplicationContext gets initialized or
     * refreshed.
     */

    @Autowired
    Simulator simulator;

    private Logger logger = LogManager.getLogger(ApplicationStartup.class);

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        try {
            simulator.startup();
        } catch (ConveyorHubException e) {
            logger.error(e);
        }
        return;
    }

    @Bean
    public Conveyor instantiateConveyor() {
        return new Conveyor();
    }

}
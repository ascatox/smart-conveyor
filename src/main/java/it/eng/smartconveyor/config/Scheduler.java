package it.eng.smartconveyor.config;

import it.eng.smartconveyor.exception.ConveyorHubException;
import it.eng.smartconveyor.simulate.Simulator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ascatox
 */
@Component
public class Scheduler {
    private Logger logger = LogManager.getLogger(Scheduler.class);

    @Autowired
    Simulator simulator;

    @Scheduled(fixedRate = 5000) //FIXME hardcoded value of clock!!!
    public void executeClock() {
        logger.info("Starting execution at: " + new Date());
        try {
            simulator.simulate();
        } catch (ConveyorHubException e) {
            logger.error(e);
        }
    }
}

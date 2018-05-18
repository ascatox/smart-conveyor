package it.eng.smartconveyor.exception;

import java.util.function.Function;

public class ConveyorHubException extends Exception {

    public ConveyorHubException() {
        super();
    }

    public ConveyorHubException(String message) {
        super(message);
    }

    public ConveyorHubException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConveyorHubException(Throwable cause) {
        super(cause);
    }

    protected ConveyorHubException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
//
//    public ConveyorHubException(Function function, String message) {
//        super(function.name() + " " + message);
//
//    }
//

}


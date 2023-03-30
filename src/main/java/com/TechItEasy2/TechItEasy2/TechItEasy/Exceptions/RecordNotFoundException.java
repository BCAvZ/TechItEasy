package com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

//    public RecordNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public RecordNotFoundException(Throwable cause) {
//        super(cause);
//    }
//
//    public RecordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
}

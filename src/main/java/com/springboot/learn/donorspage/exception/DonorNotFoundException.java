package com.springboot.learn.donorspage.exception;

public class DonorNotFoundException extends RuntimeException {

    public DonorNotFoundException(String message) {
        super(message);
    }

}

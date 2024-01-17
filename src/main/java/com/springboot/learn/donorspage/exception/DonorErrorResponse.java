package com.springboot.learn.donorspage.exception;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonorErrorResponse {

    private int status;
    private  String message;
    private String cause;
}

package com.user.management.model;

import lombok.Data;

@Data
public class Response {

    private User user;
    private String responseCode;
    private String responseMessage;
}

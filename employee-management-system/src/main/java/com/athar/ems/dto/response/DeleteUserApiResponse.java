package com.athar.ems.dto.response;

import java.time.LocalDateTime;

public class DeleteUserApiResponse {
    private boolean success;
    private String message;

    public DeleteUserApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public static <T> DeleteUserApiResponse sucess(String message) {
        return new DeleteUserApiResponse(true, message);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

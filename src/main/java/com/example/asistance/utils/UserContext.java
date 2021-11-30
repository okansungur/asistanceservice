package com.example.asistance.utils;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
    public static final String CORRELATION_ID = "gtw-correlation-id";
    public static final String AUTH_TOKEN = "gtw-auth-token";
    public static final String ASIST_ID = "gtw-asistant-id";
    public static final String USER_ID = "gtw-user-id";

    private String correlationId = new String();
    private String authToken = new String();
    private String asistId = new String();
    private String userId = new String();

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAsistId() {
        return asistId;
    }

    public void setAsistId(String asistId) {
        this.asistId = asistId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}

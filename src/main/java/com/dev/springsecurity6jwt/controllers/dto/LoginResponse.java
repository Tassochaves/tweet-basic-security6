package com.dev.springsecurity6jwt.controllers.dto;

public record LoginResponse(String accessToken, Long expiresIn) {

}

package dev.sarangan.productservicettseve.clients.authenticationClient.dtos;

import dev.sarangan.productservicettseve.clients.authenticationClient.models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDto {
    private UserDto userDto;

    private SessionStatus status;
}

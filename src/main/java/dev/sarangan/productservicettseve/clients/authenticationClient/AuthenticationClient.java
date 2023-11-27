package dev.sarangan.productservicettseve.clients.authenticationClient;

import dev.sarangan.productservicettseve.clients.authenticationClient.dtos.ValidateTokenRequestDto;
import dev.sarangan.productservicettseve.clients.authenticationClient.dtos.ValidateTokenResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationClient {
    private RestTemplateBuilder restTemplateBuilder;

    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ValidateTokenResponseDto validate(String token, Long userId) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ValidateTokenRequestDto validateTokenRequestDto = new ValidateTokenRequestDto();
        validateTokenRequestDto.setToken(token);
        validateTokenRequestDto.setUserId(userId);

        ResponseEntity<ValidateTokenResponseDto> responseDtoResponseEntity = restTemplate.postForEntity(
                "http://localhost:8082/auth/validate",
                validateTokenRequestDto,
                ValidateTokenResponseDto.class
        );
        return responseDtoResponseEntity.getBody();
    }

    public void getUserDetails() {

    }
}

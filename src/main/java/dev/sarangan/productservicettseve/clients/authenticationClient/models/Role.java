package dev.sarangan.productservicettseve.clients.authenticationClient.models;

import dev.sarangan.productservicettseve.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Role extends BaseModel {
    private String name;
}

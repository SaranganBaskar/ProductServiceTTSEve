package dev.sarangan.productservicettseve.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastUpdateAt;
    private boolean isDeleted;
}

package com.emadesko.backangularcours.web.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategorieResponse {
    private Long id;
    private String nom;
}

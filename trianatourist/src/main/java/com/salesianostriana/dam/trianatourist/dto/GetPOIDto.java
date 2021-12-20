package com.salesianostriana.dam.trianatourist.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetPOIDto{

    private UUID id;
    private String name;
    private String location;
    private LocalDate date;
    private UUID category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
}

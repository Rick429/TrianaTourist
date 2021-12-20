package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.validacion.anotaciones.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder


@PhotoUnique(
        coverPhoto = "coverPhoto",
        photo2 = "photo2",
        photo3 = "photo3",
        message = "{poi.photo.url.unique}"
)
public class CreatePOIDto {

    @NotBlank
    private String name;
    @LocationFormat(message = "{poi.location.format}")
    private String location;
    private LocalDate date;
    @CategoryExists(message = "{poi.category.exists}")
    private UUID category;
    @NotBlank
    @UrlFormat(message = "{poi.photo.url.format}")
    private String coverPhoto;
    @UrlFormat(message = "{poi.photo.url.format}")
    private String photo2;
    @UrlFormat(message = "{poi.photo.url.format}")
    private String photo3;
}

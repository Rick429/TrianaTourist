package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.validacion.anotaciones.CategoryExists;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.LocationFormat;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UrlFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreatePOIDto {

    @NotBlank
    private String name;
    @LocationFormat(message = "{poi.location.format}")
    private String location;
    private LocalDate date;
    @CategoryExists(message = "{poi.category.exists}")
    private String category;
    @NotBlank
    @UrlFormat(message = "{poi.photo.url.format}")
    private String coverPhoto;
    @UrlFormat(message = "{poi.photo.url.format}")
    private String photo2;
    @UrlFormat(message = "{poi.photo.url.format}")
    private String photo3;
}

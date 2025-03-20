package com.ark.sub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "CoOrdinates",
        description = "Pojo to hold Co-Ordinates information"
)
public class CoOrdinatesDto {

    @NotNull(message = "X  Co-Ordinate can not be a null or empty")
    @PositiveOrZero(message = "X  Co-Ordinate can not be negative value")
    @Schema(
            description = "X Co-Ordinate on grid"
    )
    private Integer x;

    @NotNull(message = "Y  Co-Ordinate can not be a null or empty")
    @PositiveOrZero(message = "Y  Co-Ordinate can not be negative value")
    @Schema(
            description = "Y Co-Ordinate on grid"
    )
    private Integer y;
}

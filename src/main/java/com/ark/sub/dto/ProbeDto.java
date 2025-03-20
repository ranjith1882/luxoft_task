package com.ark.sub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Probe",
        description = "Pojo to Probe information"
)
public class ProbeDto {

    @NotEmpty(message = "Direction can not be a null or empty")
    @Pattern(regexp = "E|W|S|N", message = "Direction must be one of E, W, S, or N")
    @Schema(
            description = "Probe Facing Direction"
    )
    private String direction;

    @NotNull(message = "Co-Ordinates can not be a null or empty")
    @Schema(
            description = "Probe Current Co-Ordinates"
    )
    private CoOrdinatesDto coOrdinates;
}

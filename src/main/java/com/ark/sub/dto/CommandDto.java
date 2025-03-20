package com.ark.sub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Command",
        description = "Command to Move probe"
)
@AllArgsConstructor
@NoArgsConstructor
public class CommandDto {

    @NotEmpty(message = "Direction can not be a null or empty")
    @Pattern(regexp = "L|R|F|B", message = "Direction must either of one from L/R/F/B [L - left, R - Right , F - Forward, B -Backward]")
    @Schema(
            description = "Probe Movement Direction"
    )
    private String direction;
}

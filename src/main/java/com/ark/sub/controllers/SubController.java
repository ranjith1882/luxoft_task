package com.ark.sub.controllers;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.CommandDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.dto.ResponseDto;
import com.ark.sub.service.SubmersibleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@Tag(
        name = "Submersible probe control operations",
        description = "Perform different operations on probe to explore see bottom"
)
@RestController
@RequestMapping(path="/explore", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class SubController {

    private SubmersibleService service;

    @Operation(
            summary = "Initialize Prob REST API",
            description = "REST API to to initialize prob at desired location with facing direction"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            )
    }
    )
    @PostMapping("/initialize")
    public ResponseEntity<ResponseDto> initialize(@Valid @RequestBody ProbeDto probeDto) {
        service.initializeProbe(probeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201","Probe initialized" +probeDto));
    }

    @Operation(
            summary = "Move Prob REST API",
            description = "REST API to to Move prob to given direction"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            )
    }
    )
    @PostMapping("/move")
    public ResponseEntity<ResponseDto> move(@Valid @RequestBody CommandDto command) {
        service.move(command);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200","Probe Moved To " + command.getDirection()));
    }

    @Operation(
            summary = "Prob Position REST API",
            description = "REST API to get current prob position"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            )
    }
    )
    @GetMapping("/position")
    public ResponseEntity<CoOrdinatesDto> getPosition() {
        CoOrdinatesDto coOrdinatesDto = service.getPosition();
        return ResponseEntity.status(HttpStatus.OK).body(coOrdinatesDto);
    }

    @Operation(
            summary = "Prob visited co-ordinates REST API",
            description = "REST API to get prob visited co-ordinates"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            )
    }
    )
    @GetMapping("/visited")
    public ResponseEntity<Collection<CoOrdinatesDto>> getVisitedCoordinates() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getVisitedCoordinates());
    }
}

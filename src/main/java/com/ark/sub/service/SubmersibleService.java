package com.ark.sub.service;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;

import java.util.List;

/**
 * Service to perform actions on Prob
 */
public interface SubmersibleService {

    /**
     * Initialize Probe
     * @param probeDto
     */
    boolean initializeProbe(ProbeDto probeDto);

    /**
     * Move Probe in given direction
     * @return
     */
    CoOrdinatesDto move();

    /**
     * Return current Co-ordinates of Prob
     * @return
     */
    CoOrdinatesDto getPosition();

    /**
     * Return list of visited co-ordinates of Prob
     * @return
     */
    List<CoOrdinatesDto> getVisitedCoordinates();

}

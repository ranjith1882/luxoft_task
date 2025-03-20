package com.ark.sub.repository;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;

import java.util.List;

/**
 * SubmersibleRepository handles data that is related to
 * Submersible Pod information
 * Probe instance initialization
 * Probe visited co-ordinates
 * Update current co-ordinates for Probe
 */
public interface SubmersibleRepository {

    /**
     * Initializes pod
     * @param probeDto
     */
    void initializePod(ProbeDto probeDto);

    /**
     * Update co-ordinates of Probe
     * @param coOrdinates
     */
    void updateCoOrdinates(CoOrdinatesDto coOrdinates);

    /**
     * Return list of all co-ordinates of Probe from Probe initialized to current location.
     * @return
     */
    List<CoOrdinatesDto> getVisitedCoOrdinates();
}

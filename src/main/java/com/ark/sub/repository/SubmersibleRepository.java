package com.ark.sub.repository;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.exception.ProbeNotInitializeException;

import java.util.List;
import java.util.Set;

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
    boolean initializeProbe(ProbeDto probeDto);

    /**
     * Update co-ordinates of Probe
     * @param coOrdinates
     */
    CoOrdinatesDto updateCoOrdinates(CoOrdinatesDto coOrdinates) throws ProbeNotInitializeException;


    /**
     * Update Probe Face Direction when turn left or right
     * @param direction
     * @return
     * @throws ProbeNotInitializeException
     */
    String updateProbFaceDirection(String direction) throws ProbeNotInitializeException;

    /**
     * Return list of all co-ordinates of Probe from Probe initialized to current location.
     * @return
     */
    Set<CoOrdinatesDto> getVisitedCoOrdinates() throws ProbeNotInitializeException;

    String getProbFaceDirection() throws ProbeNotInitializeException;

    CoOrdinatesDto getProbCurrentCoOrdinates () throws ProbeNotInitializeException;
}

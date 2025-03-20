package com.ark.sub.repository.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.exception.GridLimitException;
import com.ark.sub.exception.ProbeNotInitializeException;
import com.ark.sub.repository.SubmersibleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SubmersibleRepositoryImplTest {

    private SubmersibleRepository repository;


    @BeforeEach
    void setUp() {
        repository = new SubmersibleRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    private boolean initializeProbe()
    {
        return  repository.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,10)));
    }

    @Test
    void testInitializeProb() {
      assertTrue(initializeProbe());
    }

    @Test
    void testUpdateCoOrdinates() throws ProbeNotInitializeException {
        initializeProbe();
        CoOrdinatesDto newCoOrdinates =  repository.updateCoOrdinates(new CoOrdinatesDto(11, 22));
        assertEquals(11, newCoOrdinates.getX());
        assertEquals(22, newCoOrdinates.getY());
    }

    @Test
    void testUpdateCoOrdinatesWhenProbNotInitialized() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            repository.updateCoOrdinates(new CoOrdinatesDto(11, 22));
        });
    }

    @Test
    void testGetVisitedCoOrdinates() throws ProbeNotInitializeException {
        initializeProbe();
        Set<CoOrdinatesDto> visitedCoOrdinates = repository.getVisitedCoOrdinates();
        assertEquals(1, visitedCoOrdinates.size());
        CoOrdinatesDto newCoOrdinates = visitedCoOrdinates.stream().findFirst().get();
        assertEquals(5, newCoOrdinates.getX());
        assertEquals(10, newCoOrdinates.getY());
    }

    @Test
    void testGetVisitedCoOrdinatesWhenProbNotInitialized() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            repository.getVisitedCoOrdinates();
        });
    }

    @Test
    void testGetVisitedCoOrdinatesAfterMultipleUpdates() throws ProbeNotInitializeException {
        initializeProbe();
        repository.updateCoOrdinates(new CoOrdinatesDto(11, 22));
        repository.updateCoOrdinates(new CoOrdinatesDto(33, 44));
        Set<CoOrdinatesDto> visitedCoOrdinates = repository.getVisitedCoOrdinates();
        assertEquals(3, visitedCoOrdinates.size());
        assertTrue(visitedCoOrdinates.contains(new CoOrdinatesDto(5,10)));
        assertTrue(visitedCoOrdinates.contains(new CoOrdinatesDto(11,22)));
        assertTrue(visitedCoOrdinates.contains(new CoOrdinatesDto(33,44)));
    }

    @Test
    void testUpdateProbFaceDirection() throws ProbeNotInitializeException {
        initializeProbe();
        repository.updateProbFaceDirection("S");
    }

    @Test
    void testUpdateProbFaceDirectionWhenProbNotInitialized()
    {
        assertThrows(ProbeNotInitializeException.class, () -> {
            repository.updateProbFaceDirection("S");
        });
    }
}
package com.ark.sub.service.impl;

import com.ark.sub.constants.ApplicationConstants;
import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.CommandDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.exception.ProbeNotInitializeException;
import com.ark.sub.repository.SubmersibleRepository;
import com.ark.sub.repository.impl.GridRepositoryImpl;
import com.ark.sub.repository.impl.SubmersibleRepositoryImpl;
import com.ark.sub.service.SubmersibleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ark.sub.constants.ApplicationConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class SubmersibleServiceImplTest {

    private SubmersibleService service;
    private SubmersibleRepository repository;

    @BeforeEach
    void setUp() {
        repository = new SubmersibleRepositoryImpl();
        service = new SubmersibleServiceImpl(new GridRepositoryImpl(), repository);
    }


    @AfterEach
    void tearDown() {
    }


    @Test
    void testInitializeProbe() {
       assertTrue(service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,10))));
    }

    @Test
    void testInitializeProbeOutOfGrid() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,101)));
        });
    }

    @Test
    void testInitializeProbeAtObstacles() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(10,20)));
        });
    }

    @Test
    void testMoveForwardEastFaceProb() {
        assertTrue(service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("F"));
        assertEquals(4, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
    }

    @Test
    void testMoveBackwardEastFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("B"));
        assertEquals(6, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
    }

    @Test
    void testMoveLeftEastFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("L"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(NORTH, repository.getProbFaceDirection());
    }

    @Test
    void testMoveRightEastFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("E", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("R"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(SOUTH, repository.getProbFaceDirection());
    }

    @Test
    void testMoveForwardWestFaceProb() {
        assertTrue(service.initializeProbe(new ProbeDto("W", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("F"));
        assertEquals(6, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
    }

    @Test
    void testMoveBackwardWestFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("W", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("B"));
        assertEquals(4, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
    }

    @Test
    void testMoveLeftWestFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("W", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("L"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(SOUTH, repository.getProbFaceDirection());
    }

    @Test
    void testMoveRightWestFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("W", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("R"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(NORTH, repository.getProbFaceDirection());
    }

    @Test
    void testMoveForwardNorthFaceProb() {
        assertTrue(service.initializeProbe(new ProbeDto("N", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("F"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 11, coOrdinates.getY());
    }

    @Test
    void testMoveBackwardNorthFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("N", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("B"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 9, coOrdinates.getY());
    }

    @Test
    void testMoveLeftNorthFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("N", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("L"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(WEST, repository.getProbFaceDirection());
    }

    @Test
    void testMoveRightNorthFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("N", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("R"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(EAST, repository.getProbFaceDirection());
    }

    @Test
    void testMoveForwardSouthFaceProb() {
        assertTrue(service.initializeProbe(new ProbeDto("S", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("F"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 9, coOrdinates.getY());
    }

    @Test
    void testMoveBackwardSouthFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("S", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("B"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 11, coOrdinates.getY());
    }

    @Test
    void testMoveLeftSouthFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("S", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("L"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(EAST, repository.getProbFaceDirection());
    }

    @Test
    void testMoveRightSouthFaceProbe() {
        assertTrue(service.initializeProbe(new ProbeDto("S", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.move(new CommandDto("R"));
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
        assertEquals(WEST, repository.getProbFaceDirection());
    }
    @Test
    void testMoveWhenProbNotInitialize() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            service.move(new CommandDto("R"));
        });
    }

    @Test
    void testGetPosition() {
        assertTrue(service.initializeProbe(new ProbeDto("S", new CoOrdinatesDto(5,10))));
        CoOrdinatesDto coOrdinates = service.getPosition();
        assertEquals(5, coOrdinates.getX());
        assertEquals( 10, coOrdinates.getY());
    }

    @Test
    void testGetPositionWhenProbNotInitialize() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            service.getPosition();
        });
    }

    @Test
    void testGetVisitedCoordinates() {
       assertTrue(service.initializeProbe(new ProbeDto("S", new CoOrdinatesDto(5,10))));
       assertEquals(1, service.getVisitedCoordinates().size());
    }

    @Test
    void testGetVisitedCoordinatesWhenProbNotInitialize() {
        assertThrows(ProbeNotInitializeException.class, () -> {
            service.getVisitedCoordinates();
        });
    }
}
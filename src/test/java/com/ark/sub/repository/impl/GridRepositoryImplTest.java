package com.ark.sub.repository.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.exception.GridLimitException;
import com.ark.sub.exception.ObstaclesException;
import com.ark.sub.repository.GridRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridRepositoryImplTest {

    private GridRepository gridRepository = new GridRepositoryImpl();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void tesIsValid() throws ObstaclesException, GridLimitException {
        assertTrue(gridRepository.isValid(new CoOrdinatesDto(10, 21)));
    }

    @Test
    void tesIsValidOutOfGrid_X_Min()  {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.isValid(new CoOrdinatesDto(-1, 20));
        });
    }

    @Test
    void tesIsValidOutOfGrid_X_Max() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.isValid(new CoOrdinatesDto(101, 20));
        });
    }

    @Test
    void tesIsValidOutOfGrid_Y_Min() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.isValid(new CoOrdinatesDto(12, -1));
        });
    }

    @Test
    void tesIsValidOutOfGrid_Y_Max() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.isValid(new CoOrdinatesDto(12, 101));
        });
    }

    @Test
    void tesIsValidWhenObstacles() {
        assertThrows(ObstaclesException.class, () -> {
            gridRepository.isValid(new CoOrdinatesDto(10, 20));
        });

        assertThrows(ObstaclesException.class, () -> {
            gridRepository.isValid(new CoOrdinatesDto(30, 40));
        });
    }

    @Test
    void testGetNextCoOrdinatesOnX() throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = gridRepository.getNextCoOrdinatesOnX(new CoOrdinatesDto(5, 40));
        assertEquals(6, newCoOrdinates.getX());
        assertEquals(40, newCoOrdinates.getX());
    }

    @Test
    void testGetNextCoOrdinatesOnXWhenGoingGridOutOfLimit() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.getNextCoOrdinatesOnX(new CoOrdinatesDto(100, 1));
        });
    }

    @Test
    void testGetNextCoOrdinatesOnXWhenObstaclesHas() {
        assertThrows(ObstaclesException.class, () -> {
            gridRepository.getNextCoOrdinatesOnX(new CoOrdinatesDto(9, 20));
        });

    }

    @Test
    void testGetPrevCoOrdinatesOnX() throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = gridRepository.getPrevCoOrdinatesOnX(new CoOrdinatesDto(5, 40));
        assertEquals(4, newCoOrdinates.getX());
        assertEquals(40, newCoOrdinates.getX());
    }

    @Test
    void testGetPrevCoOrdinatesOnXWhenGoingGridOutOfLimit() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.getPrevCoOrdinatesOnX(new CoOrdinatesDto(0, 1));
        });
    }

    @Test
    void testGetPrevCoOrdinatesOnXWhenObstaclesHas() {
        assertThrows(ObstaclesException.class, () -> {
            gridRepository.getPrevCoOrdinatesOnX(new CoOrdinatesDto(11, 20));
        });
    }

    @Test
    void testGetNextCoOrdinatesOnY() throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = gridRepository.getNextCoOrdinatesOnY(new CoOrdinatesDto(5, 40));
        assertEquals(5, newCoOrdinates.getX());
        assertEquals(41, newCoOrdinates.getX());
    }

    @Test
    void testGetNextCoOrdinatesOnYWhenGoingGridOutOfLimit() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.getNextCoOrdinatesOnY(new CoOrdinatesDto(0, 100));
        });
    }

    @Test
    void testGetNextCoOrdinatesOnYWhenObstaclesHas() {
        assertThrows(ObstaclesException.class, () -> {
            gridRepository.getNextCoOrdinatesOnY(new CoOrdinatesDto(30, 39));
        });
    }

    @Test
    void testGetPrevCoOrdinatesOnY() throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = gridRepository.getPrevCoOrdinatesOnY(new CoOrdinatesDto(5, 40));
        assertEquals(5, newCoOrdinates.getX());
        assertEquals(39, newCoOrdinates.getX());
    }

    @Test
    void testGetPrevCoOrdinatesOnYWhenGoingGridOutOfLimit() {
        assertThrows(GridLimitException.class, () -> {
            gridRepository.getPrevCoOrdinatesOnY(new CoOrdinatesDto(10, 0));
        });
    }

    @Test
    void testGetPrevCoOrdinatesOnYWhenObstaclesHas() {
        assertThrows(ObstaclesException.class, () -> {
            gridRepository.getPrevCoOrdinatesOnY(new CoOrdinatesDto(30, 41));
        });
    }
}
package com.ark.sub.repository;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.exception.GridLimitException;
import com.ark.sub.exception.ObstaclesException;

import java.util.HashSet;
import java.util.Set;

/**
 * Grid Repository hold information of
 * - Grid boundaries
 * - Obstacles co-ordinates in the Grid
 * - Return next co-ordinates on x and y
 */
public interface GridRepository {

    /**
     * Currently Grid size hard coded as 100 x 100
     * Where X axis 0 to 100 and Y axis 0 to 100
     */
    Integer X_MIN = 0;
    Integer X_MAX = 100;
    Integer Y_MIN = 0;
    Integer Y_MAX = 100;

    /**
     * Currently Obstacles co-ordinates are hard coded
     */
    Set<CoOrdinatesDto> obstaclesInGrid = new HashSet<>();

    /**
     * It validates is there any Obstacles at given co-ordinates
     * Or is it exceeded from grid limits
     * @param coOrdinates
     * @return - true if conditions meets for given co-ordinates otherwise false.
     */
    boolean isValid(CoOrdinatesDto coOrdinates) throws ObstaclesException;


    /**
     * Provide by incrementing X co-ordinate to one
     * @param coOrdinates
     * @return
     * @throws ObstaclesException
     * @throws GridLimitException
     */
    CoOrdinatesDto getNextCoOrdinatesOnX(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException;

    /**
     * Provide by decreasing X co-ordinate to one
     * @param coOrdinates
     * @return
     * @throws ObstaclesException
     * @throws GridLimitException
     */
    CoOrdinatesDto getPrevCoOrdinatesOnX(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException;

    /**
     * Provide by incrementing Y co-ordinate to one
     * @param coOrdinates
     * @return
     * @throws ObstaclesException
     * @throws GridLimitException
     */
    CoOrdinatesDto getNextCoOrdinatesOnY(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException;

    /**
     * Provide by decreasing Y co-ordinate to one
     * @param coOrdinates
     * @return
     * @throws ObstaclesException
     * @throws GridLimitException
     */
    CoOrdinatesDto getPrevCoOrdinatesOnY(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException;
}

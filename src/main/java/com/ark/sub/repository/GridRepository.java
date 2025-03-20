package com.ark.sub.repository;

import com.ark.sub.dto.CoOrdinatesDto;

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
}

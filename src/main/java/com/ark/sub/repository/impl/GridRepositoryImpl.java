package com.ark.sub.repository.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.exception.GridLimitException;
import com.ark.sub.exception.ObstaclesException;
import com.ark.sub.repository.GridRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GridRepositoryImpl implements GridRepository {

    public GridRepositoryImpl()
    {
        obstaclesInGrid.add(new CoOrdinatesDto(10, 20));
        obstaclesInGrid.add(new CoOrdinatesDto(30, 40));
    }

    @Override
    public boolean isValid(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        if (coOrdinates.getX() < X_MIN || coOrdinates.getX() > X_MAX ||
                coOrdinates.getY() < Y_MIN || coOrdinates.getY() > Y_MAX)
        {
            throw new GridLimitException("Given Co-Ordinates x: "+ coOrdinates.getX() + " y: "+ coOrdinates.getY()+" Out of Grid Range");
        }
        if (obstaclesInGrid.contains(coOrdinates))
        {
            throw new ObstaclesException("Given Co-Ordinates x: "+ coOrdinates.getX() + " y: "+ coOrdinates.getY()+" Has Obstacles");
        }
        return true;
    }

    @Override
    public CoOrdinatesDto getNextCoOrdinatesOnX(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = new CoOrdinatesDto(coOrdinates.getX()+1, coOrdinates.getY());
        return isValid(newCoOrdinates) ? newCoOrdinates : null ;
    }

    @Override
    public CoOrdinatesDto getPrevCoOrdinatesOnX(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = new CoOrdinatesDto(coOrdinates.getX()-1, coOrdinates.getY());
        return isValid(newCoOrdinates) ? newCoOrdinates : null ;
    }

    @Override
    public CoOrdinatesDto getNextCoOrdinatesOnY(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = new CoOrdinatesDto(coOrdinates.getX(), coOrdinates.getY()+1);
        return isValid(newCoOrdinates) ? newCoOrdinates : null ;
    }

    @Override
    public CoOrdinatesDto getPrevCoOrdinatesOnY(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        CoOrdinatesDto newCoOrdinates = new CoOrdinatesDto(coOrdinates.getX(), coOrdinates.getY()-1);
        return isValid(newCoOrdinates) ? newCoOrdinates : null ;
    }
}

package com.ark.sub.repository.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.exception.GridLimitException;
import com.ark.sub.exception.ObstaclesException;
import com.ark.sub.repository.GridRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GridRepositoryImpl implements GridRepository {

    @Override
    public boolean isValid(CoOrdinatesDto coOrdinates) throws ObstaclesException {
        return false;
    }

    @Override
    public CoOrdinatesDto getNextCoOrdinatesOnX(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        return null;
    }

    @Override
    public CoOrdinatesDto getPrevCoOrdinatesOnX(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        return null;
    }

    @Override
    public CoOrdinatesDto getNextCoOrdinatesOnY(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        return null;
    }

    @Override
    public CoOrdinatesDto getPrevCoOrdinatesOnY(CoOrdinatesDto coOrdinates) throws ObstaclesException, GridLimitException {
        return null;
    }
}

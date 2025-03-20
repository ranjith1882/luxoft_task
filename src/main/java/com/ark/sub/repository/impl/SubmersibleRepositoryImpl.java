package com.ark.sub.repository.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.exception.ProbeNotInitializeException;
import com.ark.sub.repository.SubmersibleRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SubmersibleRepositoryImpl implements SubmersibleRepository {

    @Override
    public void initializeProbe(ProbeDto probeDto) {

    }

    @Override
    public CoOrdinatesDto updateCoOrdinates(CoOrdinatesDto coOrdinates) throws ProbeNotInitializeException{
        return null;
    }

    @Override
    public String updateProbFaceDirection(String direction) throws ProbeNotInitializeException {
        return null;
    }

    @Override
    public List<CoOrdinatesDto> getVisitedCoOrdinates() throws ProbeNotInitializeException {
        return null;
    }
}

package com.ark.sub.repository.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.exception.ProbeNotInitializeException;
import com.ark.sub.repository.SubmersibleRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class SubmersibleRepositoryImpl implements SubmersibleRepository {

    private ProbeDto probeDto;
    private Set<CoOrdinatesDto> visitedCoOrdinates;

    @Override
    public boolean initializeProbe(ProbeDto probeDto) {
        this.probeDto = probeDto;
        visitedCoOrdinates = new HashSet<>();
        visitedCoOrdinates.add(probeDto.getCoOrdinates());
        return true;
    }

    @Override
    public CoOrdinatesDto updateCoOrdinates(CoOrdinatesDto coOrdinates) throws ProbeNotInitializeException {
        isProbeInitialized();
        probeDto.setCoOrdinates(coOrdinates);
        visitedCoOrdinates.add(probeDto.getCoOrdinates());
        return probeDto.getCoOrdinates();
    }

    private void isProbeInitialized() throws ProbeNotInitializeException {
        if (probeDto == null)
        {
            throw new ProbeNotInitializeException("Probe Not Initialized, please Initialize first");
        }
    }

    @Override
    public String updateProbFaceDirection(String direction) throws ProbeNotInitializeException {
        isProbeInitialized();
        probeDto.setDirection(direction);
        return probeDto.getDirection();
    }

    @Override
    public Set<CoOrdinatesDto> getVisitedCoOrdinates() throws ProbeNotInitializeException {
        isProbeInitialized();
        return visitedCoOrdinates;
    }
}

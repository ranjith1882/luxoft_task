package com.ark.sub.service.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.service.SubmersibleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubmersibleServiceImpl implements SubmersibleService {

    @Override
    public boolean initializeProbe(ProbeDto probeDto) {
        return false;
    }

    @Override
    public CoOrdinatesDto move() {
        return null;
    }

    @Override
    public CoOrdinatesDto getPosition() {
        return null;
    }

    @Override
    public List<CoOrdinatesDto> getVisitedCoordinates() {
        return null;
    }
}

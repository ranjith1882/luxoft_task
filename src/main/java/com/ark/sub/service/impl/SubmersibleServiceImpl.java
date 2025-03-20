package com.ark.sub.service.impl;

import com.ark.sub.dto.CoOrdinatesDto;
import com.ark.sub.dto.CommandDto;
import com.ark.sub.dto.ProbeDto;
import com.ark.sub.exception.GridLimitException;
import com.ark.sub.exception.ObstaclesException;
import com.ark.sub.exception.ProbeNotInitializeException;
import com.ark.sub.mapper.FaceDirectionMapper;
import com.ark.sub.repository.GridRepository;
import com.ark.sub.repository.SubmersibleRepository;
import com.ark.sub.service.SubmersibleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.ark.sub.constants.ApplicationConstants.*;

@Service
@AllArgsConstructor
public class SubmersibleServiceImpl implements SubmersibleService {

    private GridRepository gridRepository;
    private SubmersibleRepository submersibleRepository;

    @Override
    public boolean initializeProbe(ProbeDto probeDto) {
        try {
            if (gridRepository.isValid(probeDto.getCoOrdinates())) {
                return submersibleRepository.initializeProbe(probeDto);
            }
        } catch (ObstaclesException | GridLimitException e) {
            throw new ProbeNotInitializeException(e.getMessage());
        }
        return false;

    }

    @Override
    public CoOrdinatesDto move(CommandDto command) {
        if (LEFT.equals(command.getDirection()) || RIGHT.equals(command.getDirection()))
        {
            String faceDirection = FaceDirectionMapper.getFaceDirection(submersibleRepository.getProbFaceDirection(), command.getDirection());
            submersibleRepository.updateProbFaceDirection(faceDirection);
        }
        else
        {
            String probFaceDirection = submersibleRepository.getProbFaceDirection();
            CoOrdinatesDto curCoOrdinatesDto = submersibleRepository.getProbCurrentCoOrdinates();
            CoOrdinatesDto newCoOrdinatesDto = curCoOrdinatesDto;
            try {
                switch (command.getDirection()+probFaceDirection)
                {
                    case FOR_WARD+EAST:
                    case BACK_WARD+WEST:
                        newCoOrdinatesDto = gridRepository.getPrevCoOrdinatesOnX(curCoOrdinatesDto);
                        break;
                    case BACK_WARD+EAST:
                    case FOR_WARD+WEST:
                        newCoOrdinatesDto = gridRepository.getNextCoOrdinatesOnX(curCoOrdinatesDto);
                        break;
                    case FOR_WARD+NORTH:
                    case BACK_WARD+SOUTH:
                        newCoOrdinatesDto = gridRepository.getNextCoOrdinatesOnY(curCoOrdinatesDto);
                        break;
                    case BACK_WARD+NORTH:
                    case FOR_WARD+SOUTH:
                        newCoOrdinatesDto = gridRepository.getPrevCoOrdinatesOnY(curCoOrdinatesDto);
                        break;
                }
                submersibleRepository.updateCoOrdinates(newCoOrdinatesDto);
            } catch (ObstaclesException | GridLimitException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return submersibleRepository.getProbCurrentCoOrdinates();
    }

    @Override
    public CoOrdinatesDto getPosition() {
        return submersibleRepository.getProbCurrentCoOrdinates();
    }

    @Override
    public Set<CoOrdinatesDto> getVisitedCoordinates() {
        return submersibleRepository.getVisitedCoOrdinates();
    }
}

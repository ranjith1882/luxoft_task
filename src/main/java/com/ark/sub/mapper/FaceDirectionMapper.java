package com.ark.sub.mapper;


import com.ark.sub.exception.ProbeNotMoveException;

import java.util.ArrayList;
import java.util.List;

import static com.ark.sub.constants.ApplicationConstants.LEFT;
import static com.ark.sub.constants.ApplicationConstants.RIGHT;
import static com.ark.sub.constants.ApplicationConstants.SOUTH;
import static com.ark.sub.constants.ApplicationConstants.NORTH;
import static com.ark.sub.constants.ApplicationConstants.EAST;
import static com.ark.sub.constants.ApplicationConstants.WEST;
public class FaceDirectionMapper {

    private static List<String> validDirection = new ArrayList<>();
    private static List<String> validMovements = new ArrayList<>();

    static
    {
        validDirection.add(EAST);
        validDirection.add(WEST);
        validDirection.add(NORTH);
        validDirection.add(SOUTH);
        validMovements.add(LEFT);
        validMovements.add(RIGHT);
    }

    public static String getFaceDirection(String direction, String movement)
    {
        String newDirection = direction;
        if (validateInputs(direction, movement)) {

            switch (direction) {
                case EAST:
                    newDirection = LEFT.equals(movement) ? NORTH : SOUTH;
                    break;
                case WEST:
                    newDirection = LEFT.equals(movement) ? SOUTH : NORTH;
                    break;
                case SOUTH:
                    newDirection = LEFT.equals(movement) ? EAST : WEST;
                    break;
                case NORTH:
                    newDirection = LEFT.equals(movement) ? WEST : EAST;
                    break;
            }
        }
        else
        {
            throw new ProbeNotMoveException("Wrong directions given");
        }
        return newDirection;
    }

    private static boolean validateInputs(String direction, String movement)
    {
        return validDirection.contains(direction) && validMovements.contains(movement);
    }
}

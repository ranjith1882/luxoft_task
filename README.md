# REST API for to explore ocean floor with submersible probe.

As part of this API Ocean Floor split into grid where grid 100 X 100
This API supports 
 - To initialize one Prob
 - Move Probe in Forward, Backward, Left and Right Directions
 - Provide current co-ordinates of Prob
 - Give all visited  co-ordinates of Prob since it initialized

API provide appropriate response code 
 - when Prob moving out of grid co-ordinates
 - When try to move next co-ordinates obstacles
 - When Prob trying to initialize out of grid co-ordinates or at given co-ordinates has obstacles

Grid has some obstacles (currently hard coded these values)

Can see API in swagger UI at http://localhost:8080/swagger-ui/index.html when starting application
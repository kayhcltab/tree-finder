# tree-finder
This service takes a point(x,y coordinates) and a radius in meters and then returns the tree names and their count in that radius

To start in the tree-finder project folder, run below command in git bash:
mvn clean spring-boot:run

or

In IDE, run this main class: Application

Open below url in browser:
http://localhost:8080/api/trees?x_coordinate=1027431.148&y_coordinate=202756.7687&radius=50.00

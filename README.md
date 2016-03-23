# socket-demo
This is a demo to demonstrate how one can use websockets to send data. The data can be converted to an object, which can then be modified to xml. The xml data is then sent to a remote ip on a specific port. The demo uses spring-boot (1.3.3.RELEASE) to demonstrate these messaging capabilities.

## Build and run

To run the project:
  >.gradlew clean build bootRun
  
Once this is complete, head over to your favourite browser and access this link:
  >http://localhost:8080/home
  

Open up your console (webkit browsers) and you will be able to see the messages from the websocket connections.

## Installation

To retrieve the project, one can access this link: 
 >https://github.com/nguni52/socket-demo

## Tests

To run the tests, go to the root of the project and run:
  >.gradlew clean test


## API Reference
In this demo, I used the XStream library, which is developed by thoughtworks

## Contributors

There is currently only one contributor, and since this is a quick demo, I am not expecting this project to grow much.

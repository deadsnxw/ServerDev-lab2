# Server Software Development Technologies (SSDT) Laboratory Work №1
## How to start project locally ?
:heavy_exclamation_mark:Make sure you have installed at least Java 17:heavy_exclamation_mark:
- Clone this repository  
- Open project in your IDE / Code Editor  
- Open terminal in your IDE/Code Editor  
```
./gradlew build
./gradlew bootRun
``` 
## How to start project with Docker ?
- Clone this repository  
- Open project in your IDE / Code Editor  
- Open terminal in your IDE/Code Editor  
```
./gradlew build
docker build -t <name> .
docker run -p 8080:8080 <name>
```

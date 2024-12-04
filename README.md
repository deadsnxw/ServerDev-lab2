# Server Software Development Technologies (SSDT) Laboratory Work №3
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
## Extra Task
Variant: Group IM-24
24 / 3 = 8 (residue 0)
Task: Accounting for income - you need to make an entity “account” where you can add money  
as it comes in (for each user different) and from there funds are debited atomically when creating a new expense.  
The logic of going into the red is left to the discretion of students (you can either allow it or prohibit it)


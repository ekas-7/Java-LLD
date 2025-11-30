Elevator example

This small LLD example demonstrates a minimal elevator system.

Structure:
- Src/
  - Elevator.java        : Elevator model and movement simulation
  - ElevatorController.java : Simple controller that selects elevators and fulfills requests
  - Request.java         : A request from a floor to another floor
  - Direction.java       : Direction enum (UP/DOWN/NONE)
  - Main.java            : Small simulation entrypoint

How to compile and run (from project root):

```bash
# compile
javac "5. LLD Exampes/Elevator/Src"/*.java -d "5. LLD Exampes/Elevator/bin"

# run
java -cp "5. LLD Exampes/Elevator/bin" Main
```

Notes:
- This is intentionally minimal to illustrate structure and basic control flow.
- Improvements: asynchronous movement, request queueing, multi-elevator dispatching policies, tests.

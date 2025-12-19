# Java Low-Level Design (LLD) Practice

A comprehensive repository for learning and practicing Low-Level Design concepts, Design Patterns, SOLID Principles, and Object-Oriented Programming in Java.

## Table of Contents

- [Overview](#overview)
- [Repository Structure](#repository-structure)
- [Topics Covered](#topics-covered)
- [Getting Started](#getting-started)
- [Design Patterns](#design-patterns)
- [LLD Examples](#lld-examples)
- [Contributing](#contributing)

## Overview

This repository contains implementations and examples of:
- Object-Oriented Programming concepts
- SOLID Principles
- Design Patterns (Creational, Structural, Behavioral)
- Real-world Low-Level Design problems
- Java Collections Framework
- Concurrency in Java

## Repository Structure

```
├── 0.Java/                          # Java Collections Framework
│   ├── Collections/                 # List, Set, Queue implementations
│   └── Maps/                        # HashMap, TreeMap, LinkedHashMap
│
├── 1. Objects/                      # OOP Basics
│   └── vehicles/                    # Object creation examples
│
├── 2. Relations/                    # OOP Relationships
│   ├── Association.java             # Has-a relationship
│   ├── Aggregation.java             # Weak association
│   ├── Composition.java             # Strong association
│   ├── Dependency.java              # Uses-a relationship
│   └── Inheritance.java             # Is-a relationship
│
├── 3. Principles/                   # Design Principles
│   └── SOLID/                       # SOLID principles implementation
│       ├── Single.java              # Single Responsibility Principle
│       ├── OpenClose.java           # Open/Closed Principle
│       └── Liskov.java              # Liskov Substitution Principle
│
├── 4. Patterns/                     # Design Patterns
│   ├── Creational/                  # Object creation patterns
│   │   ├── Singleton.java
│   │   ├── Factory.java
│   │   ├── Builder.java
│   │   └── Prototype.java
│   │
│   ├── Structural/                  # Object composition patterns
│   │   ├── Adapter/
│   │   ├── Bridge/
│   │   ├── Composite/
│   │   ├── Decorator/
│   │   ├── Facade/
│   │   ├── Flyweight/
│   │   └── Proxy/
│   │
│   └── Behavioral/                  # Object interaction patterns
│       ├── Chain.java               # Chain of Responsibility
│       ├── Command.java
│       ├── Iterator.java
│       ├── Mediator.java
│       ├── Observer.java
│       ├── Strategy.java
│       ├── Template.java
│       ├── Visitor.java
│       └── State/
│
├── 5. LLD Examples/                 # Real-world system designs
│   ├── 1. Tic_Tac_Toe/
│   ├── 2. Chess/
│   ├── 3. Snakes_game/
│   ├── 4. Elevator/
│   ├── 5. Parking_lot/
│   ├── 6. Inventory_Management_System/
│   └── 7. Car_rental_System/
│
└── 6. Concurrency/                  # Multithreading concepts
    ├── 01_ThreadClass_runnable/
    └── 02_ThreadPool/
```

## Topics Covered

### 1. Java Collections Framework
- **List**: ArrayList, LinkedList, Stack, Vector
- **Set**: HashSet, LinkedHashSet, TreeSet
- **Queue**: ArrayDeque, LinkedList, PriorityQueue
- **Map**: HashMap, LinkedHashMap, TreeMap

### 2. Object-Oriented Programming
- **Inheritance**: Is-a relationship
- **Association**: Has-a relationship
- **Aggregation**: Weak association
- **Composition**: Strong association
- **Dependency**: Uses-a relationship

### 3. SOLID Principles
- **S**ingle Responsibility Principle (SRP)
- **O**pen/Closed Principle (OCP)
- **L**iskov Substitution Principle (LSP)
- **I**nterface Segregation Principle (ISP)
- **D**ependency Inversion Principle (DIP)

## Design Patterns

### Creational Patterns
Design patterns that deal with object creation mechanisms.

- **Singleton**: Ensures a class has only one instance
- **Factory**: Creates objects without specifying exact class
- **Builder**: Constructs complex objects step by step
- **Prototype**: Creates new objects by copying existing ones

### Structural Patterns
Design patterns that deal with object composition.

- **Adapter**: Allows incompatible interfaces to work together
- **Bridge**: Separates abstraction from implementation
- **Composite**: Composes objects into tree structures
- **Decorator**: Adds new functionality to objects dynamically
- **Facade**: Provides simplified interface to complex subsystem
- **Flyweight**: Minimizes memory usage by sharing data
- **Proxy**: Provides placeholder for another object

### Behavioral Patterns
Design patterns that deal with object collaboration and responsibility.

- **Chain of Responsibility**: Passes request along chain of handlers
- **Command**: Encapsulates requests as objects
- **Iterator**: Accesses elements sequentially without exposing structure
- **Mediator**: Reduces coupling between communicating objects
- **Memento**: Captures and restores object state
- **Observer**: Notifies multiple objects about state changes
- **State**: Alters object behavior when state changes
- **Strategy**: Defines family of algorithms and makes them interchangeable
- **Template Method**: Defines skeleton of algorithm, subclasses fill in details
- **Visitor**: Separates algorithms from objects they operate on

## LLD Examples

### 1. Tic Tac Toe
Classic two-player game implementation with winning logic.

### 2. Chess
Complete chess game with piece movements and game rules.

### 3. Snakes Game
Snake game implementation with collision detection.

### 4. Elevator System
- Command Pattern for elevator operations
- Observer Pattern for floor requests
- Strategy Pattern for scheduling algorithms
- Handles multiple elevators and optimal scheduling

### 5. Parking Lot System
Multi-level parking lot with different vehicle types and pricing strategies.

### 6. Inventory Management System
- Product factory for different product types
- Replenishment strategies
- Inventory tracking and management

### 7. Car Rental System
- Vehicle factory for different vehicle types
- Payment strategy pattern
- Booking and rental management

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running Examples

1. Clone the repository:
```bash
git clone https://github.com/ekas-7/Java-LLD.git
cd Java-LLD
```

2. Navigate to any example directory:
```bash
cd "5. LLD Exampes/4. Elevator"
```

3. Compile and run:
```bash
javac Main.java
java Main
```

## Concurrency

Learn about multithreading and concurrent programming:
- Thread creation using Thread class and Runnable interface
- Thread pools and executor services
- Synchronization and thread safety

## Notes

Each directory contains:
- Source code implementations
- README files with detailed explanations
- Compiled class files for quick execution

## Contributing

Contributions are welcome! Feel free to:
- Add new design pattern examples
- Implement additional LLD problems
- Improve existing implementations
- Fix bugs or add documentation

## License

This project is open source and available for educational purposes.


---

Star this repository if you find it helpful!

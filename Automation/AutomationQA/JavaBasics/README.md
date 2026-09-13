# Java Basics

This module contains Java fundamentals and object-oriented programming exercises completed as part of the TechAxis QA and automation training workspace.

## Topics Covered

- Classes and objects
- Constructors
- Inheritance and polymorphism
- Abstraction
- Access modifiers
- Basic vehicle and company domain examples
- Homework exercises in the `HomeWork` package

## Source Layout

```text
JavaBasics/
└── src/
    ├── Main.java
    ├── Day2/       # Core class and inheritance exercises
    ├── Day3/       # Access modifiers and abstraction
    └── HomeWork/   # Constructor and company examples
```

This is a plain Java learning module and does not currently include a Maven build file. Open the project in IntelliJ IDEA or compile the source files with a JDK directly.

## Compile and Run

From this directory, compile the source tree into a temporary output directory:

```bash
mkdir -p out
javac -d out $(find src -name '*.java')
```

Run the entry point with:

```bash
java -cp out Main
```
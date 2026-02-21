# Java Expression Parsing Engine

![Java CI](https://github.com/Mena-Hanna/expression-calculator-java/actions/workflows/ci.yml/badge.svg)

A modular mathematical expression parsing engine built with **Java 21**, **Maven**, and **JUnit 5**, featuring automated validation through **GitHub Actions CI**.

This project evaluates mathematical expressions by implementing a full compiler-style execution pipeline:

- Lexical analysis (tokenization)
- Infix to postfix transformation using Dijkstra’s Shunting Yard algorithm
- Stack-based postfix evaluation

The goal of this project is to demonstrate practical understanding of data structures, parsing algorithms, clean architecture, automated testing, and professional build tooling.

---

## Key Features

- Supports operators: `+`, `-`, `*`, `/`, `^`
- Nested parentheses handling
- Negative numbers and decimal values
- Correct operator precedence and associativity
- Division-by-zero detection
- Modular separation of concerns
- Comprehensive JUnit 5 test suite
- Continuous Integration via GitHub Actions
- Automated JAR artifact generation

---

## Example

### Input
```text
(8 + 2 * 5) - (9 / 3 + 4) ^ 3 + (6 * (7 - 2)) / 5
```

### Output
```text
-319
```

---

## Architecture

The system is structured into clearly defined components:

### Tokenizer
Transforms raw user input into structured tokens representing numbers, operators, and parentheses.

### InfixChange
Implements the Shunting Yard algorithm to convert infix expressions into postfix notation while preserving precedence and associativity rules.

### PostfixEvaluation
Evaluates postfix expressions using a stack-based execution model.

### CalculatorMain
Coordinates user input, processing flow, and output formatting.

Time complexity for evaluation is linear with respect to the number of tokens: O(n).

---

## Project Structure

```text
src/
  main/java/com/mena/calculator
    CalculatorMain.java
    Tokenizer.java
    InfixChange.java
    PostfixEvaluation.java
  test/java/com/mena/calculator
    ExpressionCalculatorTest.java
pom.xml
```

Built with Java 21 and Maven.

---

## Build

```bash
mvn clean package
```

Generated artifact:

```text
target/expression-calculator-1.0-SNAPSHOT.jar
```

---

## Run

Using Maven:

```bash
mvn exec:java
```

Or run the JAR directly:

```bash
java -cp target/expression-calculator-1.0-SNAPSHOT.jar com.mena.calculator.CalculatorMain
```

---

## Testing

Run all unit tests:

```bash
mvn test
```

The test suite validates:

- Operator precedence
- Parentheses handling
- Negative number parsing
- Decimal arithmetic correctness
- Invalid input handling
- Division-by-zero protection

All tests execute automatically on every push through GitHub Actions.

---

## Continuous Integration

GitHub Actions automatically:

- Builds the project
- Runs the full test suite
- Generates the JAR artifact
- Validates changes on every push

CI status is displayed at the top of this README.

---

## Current Limitations

- Unary minus directly preceding parentheses (example: `-(3 + 2)`) is not currently supported.

Future improvements may include full unary operator support and enhanced expression validation.

---

## Author

**Mena Hanna**  
B.S. Computer Science  
University of Georgia
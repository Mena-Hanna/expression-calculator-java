# Java Expression Calculator

![Java CI](https://github.com/Mena-Hanna/expression-calculator-java/actions/workflows/ci.yml/badge.svg)

A modular command-line expression calculator built in **Java 21** using **Maven**, **JUnit 5**, and **GitHub Actions CI**.

The application evaluates mathematical expressions by:

1. Tokenizing raw input  
2. Converting infix notation to postfix (Reverse Polish Notation)  
3. Executing stack-based evaluation  

This project demonstrates clean project structure, automated testing, and continuous integration practices.

---

## Features

- Supports operators: `+`, `-`, `*`, `/`, `^`
- Handles nested parentheses
- Supports negative numbers and decimal values
- Correct operator precedence and associativity
- Division-by-zero detection
- JUnit 5 test suite
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

The calculator is structured into modular components:

### Tokenizer
Parses the input string into numbers, operators, and parentheses.

### InfixChange
Converts infix expressions to postfix notation using a stack-based algorithm (Shunting Yard approach).

### PostfixEvaluation
Evaluates postfix expressions using stack-based execution.

### CalculatorMain
Handles user input and coordinates execution flow.

---

## Project Structure

```text
src/
  main/java/com/mena/calculator
  test/java/com/mena/calculator
pom.xml
```

Built using **Java 21** and **Maven**.

---

## Build

```bash
mvn clean package
```

This generates a JAR file in:

```text
target/expression-calculator-1.0-SNAPSHOT.jar
```

---

## Run

Run using Maven:

```bash
mvn clean compile exec:java
```

Or run the generated JAR directly:

```bash
java -cp target/expression-calculator-1.0-SNAPSHOT.jar com.mena.calculator.CalculatorMain
```

---

## Testing

Run unit tests:

```bash
mvn test
```

Tests validate:

- Operator precedence
- Parentheses handling
- Negative numbers
- Decimal arithmetic
- Invalid input handling
- Division-by-zero detection

All tests are automatically executed on every push via GitHub Actions CI.

---

## Continuous Integration

This project uses GitHub Actions to:

- Build the project
- Run all unit tests
- Generate a JAR artifact
- Validate changes on every push

CI status is shown at the top of this README.

---

## Limitations

- Unary minus directly preceding parentheses (e.g., `-(3 + 2)`) is not currently supported.

---

## Author

**Mena Hanna**  
B.S. Computer Science — University of Georgia  
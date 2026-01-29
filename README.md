# Java Expression Calculator

A command-line calculator written in Java that evaluates mathematical expressions entered by the user.
The program supports operator precedence, parentheses, negative numbers, decimals, and exponentiation.

The calculator works by tokenizing the input expression, converting it from infix notation to postfix
(RPN), and evaluating the postfix expression using a stack-based algorithm.

## Example

Input:
(8 + 2 * 5) - (9 / 3 + 4) ^ 3 + (6 * (7 - 2)) / 5

Output:
-319

## Features
- Supports +, -, *, /, and ^ (exponentiation)
- Handles nested parentheses
- Supports negative numbers and decimal values
- Ignores whitespace in input expressions
- Correctly applies operator precedence

## Implementation Overview
- **Tokenizer**: Breaks the input string into numbers, operators, and parentheses
- **InfixChange**: Converts infix expressions to postfix notation using a stack
- **PostfixEvaluation**: Evaluates postfix expressions using a stack-based approach
- **CalculatorMain**: Handles user input and coordinates execution

## How to Run

Compile and run:
javac *.java
java CalculatorMain

## Limitations
- Unary minus directly before parentheses (e.g., -(3 + 2)) is not supported

## Author
Mena Hanna  
University of Georgia

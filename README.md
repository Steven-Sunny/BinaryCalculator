# Binary Calculator

**Faculty of Engineering & Applied Science**

**SOFE 3290U: Software Quality & Project Management**

**Lab 1: Software Quality**

# Introduction

This lab explores software project management using Apache Maven to simplify the development of a simple Java-based Binary Calculator. The goal is to gain proficiency in project initialization, build automation, and dependency management through the pom.xml file. We also implement various Maven plugins which demonstrate how to automatically generate technical documentation via Javadoc, manage external libraries, and enforce code quality through JUnit test cases. The lab also includes the design and implementation of bitwise logic (OR, AND) and multiplication functions. It also includes the writing and designing of the test cases for the new methods.

# Source Code

### App.java

App.java has a few new lines of code to test the new methods in Binary.java. It uses the previously defined binary values and allows the user to run this as their main file should they want to execute the project without trying any test cases. Although barebones compared to the testing suite, it provides a simple and intuitive way to run this Java project.

### Binary.java/or

As we know, Binary.java declares a new class called Binary that allows the user to instantiate new binary values. This new “or” method allows the operation of bitwise OR on two binary numbers. Bitwise OR checks each individual bit and compares it with the second binary value’s bit at that same position. If they are the same then that bit remains the same in the output, if one bit is of value 1 while the other is 0 then the output will have 1\.

Following this philosophy, I created a while loop that continues looping until both input values have no more bits to traverse. Each bit is compared respectively with the same bit in the other value. All offset bits are treated as 0 (i.e. 10 is treated logically as 0010 if the other value is of 4 bits). In short, the while loop will run until both binaries have no more bits to traverse while a conditional decides what value the output bit should be in each iteration.

### Binary.java/or

This new “and” method allows the operation of bitwise AND on two binary numbers. Bitwise AND checks each individual bit and compares it with the second binary value’s bit at that same position. If they are the same then that bit remains the same in the output, if one bit is of value 1 while the other is 0 then the output will have 0\.

The implementation of my code is the same as implementing the bitwise OR method.

### Binary.java/multiply

This binary multiplication method allows the multiplication of two binary numbers. It uses the partial products approach, which is the equivalent of long multiplication. Instead of dealing with digits 0–9, it simplifies things by only looking for 1s because of the binary nature of the values.

For every bit in the multiplier, the algorithm checks if it is a 1\. If it is, the multiplicand is shifted to the left by appending zeros to its end and then added to a running total. Because binary only uses 0 and 1, numbers are not “multiplied” in the traditional sense. It essentially just decides whether to add a shifted version of the first number to your result or skip it. The addition part of this method uses the add method defined in the original class implementation.

# Testing Code

### Bitwise OR Operations

or1(): Validates the standard bitwise OR logic using two binary strings of equal length to ensure each bit is correctly compared.

or2(): Verifies that the OR operation correctly handles inputs of unequal lengths, by logically padding the shorter string with leading zeros.

or3(): Ensures that performing an OR operation on two zero-value strings of different lengths results in a single 0\.

| Test Names | Test Case | Result |
| :---: | :---: | :---: |
| or1() | 1010 | 1100 | 1110 |
| or2() | 1 | 1010 | 1011 |
| or3() | 000 | 0 | 0 |

### Bitwise AND Operations

and1(): Tests basic bitwise AND functionality where the result only contains a 1 in positions where both input bits are 1\.

and2(): Checks if the AND function handles unequal lengths correctly, ensuring the operation still yields the correct numerical result when the first value is longer.

and3(): Confirms that performing an AND operation on two bitwise inverted values correctly results in 0\.

| Test Names | Test Case | Result |
| :---: | :---: | :---: |
| and1() | 1011 & 1101 | 1001 |
| and2() | 111 & 1 | 1 |
| and3() | 1010 & 0101 | 0 |

### Multiplication Operations

multiply1(): Validates the zero property of multiplication, ensuring that any binary value multiplied by 0 returns 0\.

multiply2(): Tests the identity property of multiplication to confirm that any binary value multiplied by 1 remains unchanged.

multiply3(): Verifies general multiplication logic by calculating the product of two multi-bit binary numbers.

| Test Names | Test Case | Result |
| :---: | :---: | :---: |
| multiply1() | 1011 (11) ✕ 0 (0) | 0 |
| multiply2() | 1101 (13) ✕ 1 (1) | 1101 (13) |
| multiply3() | 11 (3) ✕ 10 (2) | 110 (6) |

# Conclusion

The lessons learned in this lab surrounding the importance of setting up the Java environment using Apache Maven and the pom.xml file made me realize how much time I can save from testing. I found the initial setup quite labour intensive and frustrating. At the beginning, there was plenty of confusion between the usage of Maven and the pom.xml file. However at the same time, I drew connections likening the pom.xml file to a more traditional makefile, which slightly helped my understanding. Ultimately, I found that despite the brutal setup, it made my testing process considerably faster. In the future I plan to implement a simplified version of this process in any large coding projects. Consider reading the documentation on the source code provided on the GitHub for a more in-depth understanding of how my code works.

Github Link: [https://github.com/Steven-Sunny/BinaryCalculator](https://github.com/Steven-Sunny/BinaryCalculator)
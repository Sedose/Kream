# Kream

A lightweight Kotlin library for redirecting standard output and error streams to files.

[![](https://jitpack.io/v/com.github.Sedose/Kream.svg)](https://jitpack.io/#com.github.Sedose/Kream)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Overview

Kream provides a simple way to redirect standard output and error streams to files during the execution of a code block. This is particularly useful for:

- Capturing console output for logging purposes
- Redirecting output when running tests
- Capturing output from third-party libraries that write to stdout/stderr

## Installation

### Gradle (Kotlin DSL)

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.Sedose:Kream:1.0.3")
}
```

### Gradle (Groovy DSL)

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Sedose:Kream:1.0.3'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Sedose</groupId>
        <artifactId>Kream</artifactId>
        <version>1.0.3</version>
    </dependency>
</dependencies>
```

## Usage

### Basic Example

```kotlin
import com.github.Sedose.kream.withRedirects
import java.nio.file.Paths

fun main() {
    val stdoutFile = Paths.get("stdout.log")
    val stderrFile = Paths.get("stderr.log")
    
    withRedirects(stdout = stdoutFile, stderr = stderrFile) {
        // Any output to System.out or System.err in this block
        // will be redirected to the specified files
        println("This goes to stdout.log")
        System.err.println("This goes to stderr.log")
    }
    
    // Outside the block, streams are restored to their original targets
    println("This goes to the console")
}
```

### Redirecting Only One Stream

You can choose to redirect only stdout or stderr by passing null for the other parameter:

```kotlin
// Only redirect stdout
withRedirects(stdout = Paths.get("stdout.log"), stderr = null) {
    println("This goes to the file")
    System.err.println("This still goes to the console")
}

// Only redirect stderr
withRedirects(stdout = null, stderr = Paths.get("stderr.log")) {
    println("This goes to the console")
    System.err.println("This goes to the file")
}
```

## API Reference

### withRedirects

```kotlin
fun withRedirects(
    stdout: Path?,
    stderr: Path?,
    action: () -> Unit
)
```

Redirects standard output and/or standard error streams to the specified files during the execution of the provided action.

**Parameters:**
- `stdout`: Path to the file where standard output should be redirected, or null to leave it unchanged
- `stderr`: Path to the file where standard error should be redirected, or null to leave it unchanged
- `action`: The code block to execute with redirected streams

**Behavior:**
- If a file already exists at the specified path, it will be overwritten
- Streams are automatically restored to their original targets after the action completes, even if an exception occurs
- Any open file handles are properly closed

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Acknowledgments

- Inspired by the need for simple stream redirection in Kotlin
- Thanks to all contributors who have helped improve this library
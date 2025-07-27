package com.github.Sedose.kream

import java.io.PrintStream
import java.nio.file.Files
import java.nio.file.Path

/**
 * Redirects standard output and/or standard error streams to the specified files during the execution
 * of the provided action.
 *
 * This function temporarily redirects System.out and/or System.err to the specified file paths,
 * executes the provided action, and then restores the original streams. This is useful for capturing
 * console output for logging, testing, or when working with third-party libraries that write directly
 * to standard streams.
 *
 * Example usage:
 * ```
 * val stdoutFile = Paths.get("stdout.log")
 * val stderrFile = Paths.get("stderr.log")
 *
 * withRedirects(stdout = stdoutFile, stderr = stderrFile) {
 *     println("This goes to stdout.log")
 *     System.err.println("This goes to stderr.log")
 * }
 * ```
 *
 * @param stdout Path to the file where standard output should be redirected, or null to leave it unchanged
 * @param stderr Path to the file where standard error should be redirected, or null to leave it unchanged
 * @param action The code block to execute with redirected streams
 *
 * @throws IOException If there is an error opening or writing to the specified files
 * @throws SecurityException If a security manager exists and its checkWrite method denies write access to the files
 */
public fun withRedirects(
    stdout: Path?,
    stderr: Path?,
    action: () -> Unit,
) {
    // Store original streams
    val originalOut = System.out
    val originalErr = System.err
    
    // Create redirected streams if paths are provided
    val redirectedOut = stdout?.let { PrintStream(Files.newOutputStream(it)) }
    val redirectedErr = stderr?.let { PrintStream(Files.newOutputStream(it)) }

    // Apply redirections
    redirectedOut?.let(System::setOut)
    redirectedErr?.let(System::setErr)

    try {
        // Execute the provided action with redirected streams
        action()
    } finally {
        // Restore original streams and close redirected streams
        redirectedOut?.close()
        redirectedErr?.close()
        System.setOut(originalOut)
        System.setErr(originalErr)
    }
}

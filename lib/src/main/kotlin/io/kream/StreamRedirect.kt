package io.kream

import java.io.PrintStream
import java.nio.file.Files
import java.nio.file.Path

fun withRedirects(
    stdout: Path?,
    stderr: Path?,
    action: () -> Unit,
) {
    val originalOut = System.out
    val originalErr = System.err
    val redirectedOut = stdout?.let { PrintStream(Files.newOutputStream(it)) }
    val redirectedErr = stderr?.let { PrintStream(Files.newOutputStream(it)) }

    redirectedOut?.let(System::setOut)
    redirectedErr?.let(System::setErr)

    try {
        action()
    } finally {
        redirectedOut?.close()
        redirectedErr?.close()
        System.setOut(originalOut)
        System.setErr(originalErr)
    }
}

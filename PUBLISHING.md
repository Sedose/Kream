# Publishing to Jitpack.io

This document provides instructions for publishing this library to Jitpack.io and how consumers can include it in their projects.

## Publishing a New Version

To publish a new version of the library to Jitpack.io, follow these steps:

1. Update the version number in `lib/build.gradle.kts` (already updated to 1.0.4 for this release)
2. Commit your changes:
   ```bash
   git add lib/build.gradle.kts
   git commit -m "Bump version to 1.0.4"
   ```
3. Create a new tag with the version number:
   ```bash
   git tag -a v1.0.4 -m "Version 1.0.4"
   ```
4. Push the changes and the tag to GitHub:
   ```bash
   git push origin main
   git push origin v1.0.4
   ```
5. Jitpack.io will automatically build the new version when someone requests it for the first time.

## For Consumers

Consumers can include this library in their projects as follows:

### Gradle (Kotlin DSL)

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.Sedose:Kream:1.0.4")
}
```

### Gradle (Groovy DSL)

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Sedose:Kream:1.0.4'
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
        <version>1.0.4</version>
    </dependency>
</dependencies>
```

## Accessing Sources in IntelliJ IDEA

The library is configured to publish source JARs, which allows consumers to view the source code directly in IntelliJ IDEA. This happens automatically when the library is included as a dependency.

To view the sources in IntelliJ IDEA:
1. Include the library as a dependency as shown above
2. Navigate to the library classes in your project
3. IntelliJ IDEA will automatically download and attach the sources
4. You can also manually download sources by right-clicking on the library in the "External Libraries" section and selecting "Download Sources"

## Verifying the Release

To verify that the new version is available on Jitpack.io, visit:
https://jitpack.io/#com.github.Sedose/Kream/1.0.4

Note that Jitpack.io builds the library on-demand when it's first requested, so there might be a short delay when accessing a new version for the first time.
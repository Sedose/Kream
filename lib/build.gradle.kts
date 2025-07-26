plugins {
    kotlin("jvm") version "1.9.0"
    `java-library`
}

group = "com.github.Sedose"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    add("archives", tasks["sourcesJar"])
}

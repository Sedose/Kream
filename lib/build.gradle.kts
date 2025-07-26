plugins {
    kotlin("jvm") version "1.9.0"
    `java-library`
    `maven-publish`
}

group = "com.github.Sedose"
version = "1.0.2"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("kream") {
            from(components["java"])
            artifactId = "Kream"
        }
    }
}

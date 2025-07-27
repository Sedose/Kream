plugins {
    kotlin("jvm") version "1.9.0"
    `java-library`
    `maven-publish`
}

group = "com.github.Sedose"
version = "1.0.3"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
    withJavadocJar()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    jvmToolchain(8)
}

publishing {
    publications {
        create<MavenPublication>("kream") {
            from(components["java"])

            pom {
                name.set("Kream")
                description.set("A Kotlin library for redirecting standard output and error streams")
                url.set("https://github.com/Sedose/Kream")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("Sedose")
                        name.set("Sedose")
                        email.set("your.email@example.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Sedose/Kream.git")
                    developerConnection.set("scm:git:ssh://github.com/Sedose/Kream.git")
                    url.set("https://github.com/Sedose/Kream")
                }
            }
        }
    }
}

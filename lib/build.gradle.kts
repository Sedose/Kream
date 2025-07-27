plugins {
    kotlin("jvm") version "2.2.0"
    `java-library`
    `maven-publish`
}

group = "com.github.sedose"
version = "1.0.4"

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
                name.set("kream")
                description.set("A Kotlin library for redirecting standard output and error streams")
                url.set("https://github.com/sedose/kream")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("sedose")
                        name.set("sedose")
                        email.set("your.email@example.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/sedose/kream.git")
                    developerConnection.set("scm:git:ssh://github.com/sedose/kream.git")
                    url.set("https://github.com/sedose/kream")
                }
            }
        }
    }
}

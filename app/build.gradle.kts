plugins {
    checkstyle
    jacoco
    id("java")
    id("org.sonarqube") version "6.0.1.5171"
    id("com.github.ben-manes.versions") version "0.52.0"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

sonar {
    properties {
        property("sonar.projectKey", "qusilon_java-project-78")
        property("sonar.organization", "qusilon")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
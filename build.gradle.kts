import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"

}

group = "com.fatshaw"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    bootJar {
        mainClass.set("com.fatshaw.dddtemplate.DDDTemplateApplication")
        archiveClassifier.set("boot")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java-library")
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-jpa")

    repositories {
        mavenCentral()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.5")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.4")
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        api("io.vavr:vavr:0.10.3")
    }
}


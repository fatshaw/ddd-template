dependencies {
    implementation(project(":ddd-template-domain"))
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql")
    implementation("org.redisson:redisson:3.15.3")
}

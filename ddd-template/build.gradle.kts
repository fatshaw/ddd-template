dependencies {
    implementation(project(":ddd-template-domain"))
    runtimeOnly(project(":ddd-template-infra"))
    implementation(project(":ddd-template-client"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}

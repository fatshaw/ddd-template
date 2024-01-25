dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly(project(":ddd-template-infra"))
    implementation(project(":ddd-template-api"))

}

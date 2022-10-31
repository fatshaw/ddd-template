pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "ddd-template"

include("ddd-template-domain", "ddd-template-infra", "ddd-template-client", "ddd-template")

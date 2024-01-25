pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "ddd-template"

include("ddd-template-common","ddd-template-domain", "ddd-template-api","ddd-template-infra", "ddd-template-client", "ddd-template-starter","ddd-template-application")

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven{url = uri("https://repo.implario.dev/public")}
    }
}

rootProject.name = "example"
include("upload")

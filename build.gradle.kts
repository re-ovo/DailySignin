import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "me.rerere"
version = "1.0.0"

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjvm-default=all")
        }
    }

    processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        from("src/main/resources") {
            include("**/*.yml")
            filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to mapOf(
                "version" to project.version
            ))
        }
        filesMatching("application.properties") {
            expand(project.properties)
        }
    }

    shadowJar {
        minimize()

        val libPackage = "me.rerere.dailysign.lib"
        relocate("org.jetbrains", "$libPackage.org.jetbrains")
        relocate("kotlin","$libPackage.kotlin")
        relocate("kotlinx","$libPackage.kotlinx")
        relocate("org.intellij","$libPackage.org.intellij")
    }

    build {
        dependsOn(shadowJar)
    }

    test {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.mattstudios.me/artifactory/public/")
}

dependencies {
    // spigot api
    compileOnly("org.spigotmc:spigot-api:1.18-R0.1-SNAPSHOT")

    // placeholder api
    compileOnly("me.clip:placeholderapi:2.10.10")

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    testImplementation(kotlin("test"))
}
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "com.proximyst"
version = "0.1.0"

repositories {
    maven {
        name = "spigotmc"
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

        content {
            includeGroup("org.bukkit")
            includeGroup("org.spigotmc")
        }
    }

    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")

        content {
            includeGroup("net.md-5")
        }
    }

    maven {
        name = "papermc"
        url = uri("https://papermc.io/repo/repository/maven-public/")

        content {
            includeGroup("com.destroystokyo.paper")
            includeGroup("io.github.waterfallmc")
            includeGroup("io.papermc")
        }
    }

    maven {
        name = "aikar-repo"
        url = uri("https://repo.aikar.co/content/groups/aikar/")

        content {
            includeGroup("co.aikar")
        }
    }

    jcenter()
    mavenCentral()
}

dependencies {
    implementation("co.aikar:acf-paper:0.5.0-SNAPSHOT")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.1-R0.1-SNAPSHOT")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = sourceCompatibility
}

tasks {
    withType<ShadowJar> {
        fun reloc(vararg packages: String) =
            packages.forEach { relocate(it, "com.proximyst.sapphichours.dependencies.$it") }

        reloc(
            "co.aikar.commands",
            "co.aikar.locale"
        )
    }
}
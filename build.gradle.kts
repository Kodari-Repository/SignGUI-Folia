plugins {
    java
    alias(libs.plugins.shadow)

    id("module-java-versions") apply false
    id("kodari-publish")
}

allprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
        mavenLocal()

        maven("https://repo.tcoded.com/releases") // folialib
    }

    dependencies {
        implementation(rootProject.libs.folialib)
    }
}

subprojects {
    apply(plugin = "module-java-versions")
}

val commons = setOf("wrapper")
configure(subprojects.filter { it.name !in commons}) {
    dependencies {
        compileOnly(project(":wrapper"))
    }
}

dependencies {
    /*
     * Important
     */
    implementation(project(":wrapper"))
    implementation(project(":api"))

    /*
     * Versions
     */
    implementation(project(":Mojang1_21_R5"))
    implementation(project(":Mojang1_21_R4"))
    implementation(project(":Mojang1_21_R3"))
    implementation(project(":Mojang1_21_R2"))
    implementation(project(":Mojang1_21_R1"))
    implementation(project(":Mojang1_20_R4"))

    implementation(project(":1_21_R5"))
    implementation(project(":1_21_R5"))
    implementation(project(":1_21_R4"))
    implementation(project(":1_21_R3"))
    implementation(project(":1_21_R2"))
    implementation(project(":1_21_R1"))
    implementation(project(":1_20_R4"))
    implementation(project(":1_20_R3"))
    implementation(project(":1_20_R2"))
    implementation(project(":1_20_R1"))
    implementation(project(":1_19_R3"))
    implementation(project(":1_19_R2"))
    implementation(project(":1_19_R1"))
    implementation(project(":1_18_R2"))
    implementation(project(":1_18_R1"))
    implementation(project(":1_17_R1"))
    implementation(project(":1_16_R3"))
    implementation(project(":1_16_R2"))
    implementation(project(":1_16_R1"))
    implementation(project(":1_15_R1"))
    implementation(project(":1_14_R1"))
    implementation(project(":1_13_R2"))
    implementation(project(":1_13_R1"))
    implementation(project(":1_12_R1"))
    implementation(project(":1_11_R1"))
    implementation(project(":1_10_R1"))
    implementation(project(":1_9_R2"))
    implementation(project(":1_9_R1"))
    implementation(project(":1_8_R3"))
    implementation(project(":1_8_R2"))
    implementation(project(":1_8_R1"))
}

tasks.shadowJar {
    relocate("com.tcoded", "de.rapha149.signgui.libs")

    archiveClassifier.set("")
}
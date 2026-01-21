val java16 = setOf(
    "1_17_R1"
)

val java17 = setOf(
    "1_18_R1",
    "1_18_R2",
    "1_19_R1",
    "1_19_R2",
    "1_19_R3",
    "1_20_R1",
    "1_20_R2",
    "1_20_R3",
)

val java21 = setOf(
    "1_20_R4",
    "1_21_R1",
    "1_21_R2",
    "1_21_R3",
    "1_21_R4",
    "1_21_R5",
    "Mojang1_20_R4",
    "Mojang1_21_R1",
    "Mojang1_21_R2",
    "Mojang1_21_R3",
    "Mojang1_21_R4",
    "Mojang1_21_R5"
)

plugins {
    `java-library`
}

java {
    toolchain {
        val version = when (project.name) {
            in java21 -> 21
            in java17 -> 17
            in java16 -> 16
            else -> 8
        }
        languageVersion.set(JavaLanguageVersion.of(version))
    }
}
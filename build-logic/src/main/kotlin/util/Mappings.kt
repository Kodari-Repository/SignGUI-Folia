package util

import org.gradle.api.Project

// exceptions
private val versionExceptions = mapOf(
    "1_8_R3" to "1.8.8",
    "1_9_R2" to "1.9.4",
    "1_10_R1" to "1.10.2",
    "1_13_R2" to "1.13.2",
    "1_16_R1" to "1.16.1",
    "1_16_R2" to "1.16.2",
    "1_18_R2" to "1.18.2",
    "1_20_R2" to "1.20.2",
    "1_20_R4" to "1.20.6",
    "1_21_R1" to "1.21.1",
)

// 1_8_R1 = 1.8 // 1 is ignored
// 1_8_R2 = 1.8.3 // > 1 = + 1
fun Project.mcVersion(): String {
    val projectName = project.name
        .replace("Mojang", "")

    if (versionExceptions.containsKey(projectName))
        return versionExceptions.getValue(projectName)

    val version = projectName
        .substringBefore("_R")
        .replace("_", ".") // 1_8_R1 = 1.8
    val rversion: Int = projectName
        .substringAfter("_R")
        .toInt() // 1_8_R2 = 2

    val actualVersion = "$version${if (rversion == 1) "" else ".${rversion + 1}"}"

    return actualVersion
}
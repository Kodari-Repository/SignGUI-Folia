import util.mcVersion

plugins {
    `java-library`
}

dependencies {
    compileOnly("org.spigotmc:spigot:${mcVersion()}-R0.1-SNAPSHOT")
}
import util.mcVersion

plugins {
    id("io.papermc.paperweight.userdev")
}

dependencies {
    paperweight.paperDevBundle("${mcVersion()}-R0.1-SNAPSHOT")
}
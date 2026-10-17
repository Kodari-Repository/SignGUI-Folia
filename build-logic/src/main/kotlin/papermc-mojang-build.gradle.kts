import util.mcVersion

plugins {
    id("io.papermc.paperweight.userdev")
}

dependencies {
    paperweight.paperDevBundle("${mcVersion()}.build.+")
}
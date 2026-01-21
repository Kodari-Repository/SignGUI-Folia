plugins {
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            artifact(tasks.named("shadowJar"))
        }
    }

    repositories {
        maven {
            name = "kodari"
            url = uri("https://repo.kodari.ai/releases")
            credentials {
                username = System.getenv("KODARI_REPO_USER") ?: findProperty("kodariRepoUser") as String?
                password = System.getenv("KODARI_REPO_TOKEN") ?: findProperty("kodariRepoToken") as String?
            }
        }
    }
}

tasks.named("publish") {
    dependsOn(tasks.named("shadowJar"))
}
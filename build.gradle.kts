plugins {
    id("java")
    kotlin("jvm")
}

group = "net.exoad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.twelvemonkeys.imageio:imageio-core:3.12.0")
    implementation("com.twelvemonkeys.imageio:imageio-webp:3.12.0")
    implementation("com.twelvemonkeys.imageio:imageio-bmp:3.12.0")
    implementation("com.twelvemonkeys.imageio:imageio-metadata:3.12.0")
    implementation("com.twelvemonkeys.imageio:imageio-jpeg:3.12.0")
    implementation("com.formdev:flatlaf:3.5.2")
    implementation("com.github.weisj:jsvg:1.6.1")
    implementation("com.formdev:flatlaf-extras:3.5.2")
    implementation("com.formdev:flatlaf-intellij-themes:3.5.2")
    testImplementation("org.apache.logging.log4j:log4j-core:2.24.1")
    implementation("org.apache.logging.log4j:log4j-core:2.24.1")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.leakyabstractions:result:1.0.0.0")
    testImplementation("com.leakyabstractions:result:1.0.0.0")
    compileOnly("org.projectlombok:lombok:1.18.34")
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    implementation("org.apache.commons:commons-lang3:3.17.0")
    implementation("commons-io:commons-io:2.17.0")
    implementation("com.dorkbox:SystemTray:4.4")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
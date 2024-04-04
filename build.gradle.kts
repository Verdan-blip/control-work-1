plugins {
    id("java")
    id("war")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm")
}

group = "ru.kpfu.itis.bagaviev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework:spring-webmvc:${properties["springVersion"]}")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:${properties["tomcatVersion"]}")

    implementation("org.springframework:spring-jdbc:${properties["springVersion"]}")
    implementation("org.springframework:spring-orm:${properties["springVersion"]}")
    implementation("org.springframework:spring-context-support:${properties["springVersion"]}")
    implementation ("org.springframework.data:spring-data-jpa:2.7.18")
    implementation("org.hibernate:hibernate-core:${properties["hibernateVersion"]}")
    implementation("org.hibernate:hibernate-entitymanager:${properties["hibernateVersion"]}")
    annotationProcessor("org.hibernate:hibernate-jpamodelgen:${properties["hibernateVersion"]}")

    implementation("org.springframework.security:spring-security-core:${properties["springSecurityVersion"]}")
    implementation("org.springframework.security:spring-security-web:${properties["springSecurityVersion"]}")
    implementation("org.springframework.security:spring-security-config:${properties["springSecurityVersion"]}")
    implementation("org.springframework.security:spring-security-taglibs:${properties["springSecurityVersion"]}")

    implementation("com.cloudinary:cloudinary-core:1.38.0")

    implementation("com.mchange:c3p0:0.9.5.2")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("org.freemarker:freemarker:2.3.32")
    implementation("commons-fileupload:commons-fileupload:1.5")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}
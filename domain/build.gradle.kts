plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    val koin_version = "3.4.0"

    // Koin
    implementation("io.insert-koin:koin-core:$koin_version")
}
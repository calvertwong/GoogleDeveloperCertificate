// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    `kotlin-dsl`
}

val viewBindingModules: List<String> = listOf(
    "app", "common", "customview", "dialogs", "donate", "menu", "recyclerview", "responsiveuiconstraintlayout", "tablayout", "toasts", "viewbinding"
)

val dataBindingModules: List<String> = listOf(

)

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            url = uri("https://maven.google.com")
        }
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = Versions.kotlin_version))
        classpath("com.android.tools.build:gradle:4.0.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    when (name) {
        "app" -> configureApplication()
        else -> configureLibrary(name)
    }
    kotlinJvmTarget()
}

fun Project.configureApplication() {
    println("\nConfiguring Application")
    apply(plugin = "com.android.application")
    configureCommon()
}

fun Project.configureLibrary(name: String) {
    println("\nConfiguring Library: $name")
    apply(plugin = "com.android.library")
    configureCommon()
    configureBuildTypesForLibrary()
}

fun Project.configureCommon() {
    println("\nConfiguring Common")
    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-android-extensions")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "org.jetbrains.kotlin.android")

    configure<com.android.build.gradle.BaseExtension> {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        compileSdkVersion(29)
        defaultConfig {
            multiDexEnabled = true
            minSdkVersion(21)
            targetSdkVersion(29)
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            version = "1"
            versionName = version.toString()
            versionCode = 1
        }
        packagingOptions {
            exclude("META-INF/DEPENDENCIES.txt")
            exclude("META-INF/DEPENDENCIES")
            exclude("META-INF/dependencies.txt")
            exclude("META-INF/LICENSE.txt")
            exclude("META-INF/LICENSE")
            exclude("META-INF/license.txt")
            exclude("META-INF/LGPL2.1")
            exclude("META-INF/NOTICE.txt")
            exclude("META-INF/NOTICE")
            exclude("META-INF/notice.txt")
        }
        if (viewBindingModules.contains(name)) {
            buildFeatures.viewBinding = true
        }
        if (viewBindingModules.contains(name)) {
            buildFeatures.dataBinding = true
        }
        testOptions {
            unitTests(closureOf<com.android.build.gradle.internal.dsl.TestOptions.UnitTestOptions> {
                isIncludeAndroidResources = true
            })
        }
    }
}

fun Project.configureBuildTypesForLibrary() {
    configure<com.android.build.gradle.LibraryExtension> {
        defaultConfig {
            consumerProguardFiles.addAll(
                fileTree("proguard").toList()
            )
        }
//        Note: future use
//        flavorDimensions("environment")
//        defaultPublishConfig("release")
//        productFlavors{
//            create("dev").setDimension("environment")
//            create("prod").setDimension("environment")
//        }
//        val ignoreVariant = listOf(
//            "exampleDebug"
//        ).map(String::toLowerCase)
//        variantFilter{
//            if(name.toLowerCase() in ignoreVariant){
//                ignore = true
//            }
//        }
    }
}

fun Project.kotlinJvmTarget() =
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }
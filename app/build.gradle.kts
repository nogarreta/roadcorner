plugins {
    id("com.android.application")
    id("com.apollographql.apollo3") version "3.8.2"
}


android {
    namespace = "com.example.travelappoctober2023"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.travelappoctober2023"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.graphql-java:graphql-java:20.6")
    implementation("com.apollographql.apollo3:apollo-runtime:3.8.2")
    implementation("org.postgresql:postgresql:9.3-1100-jdbc4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

apollo {
    service("service") {
        packageName.set("com.example.travelappoctober2023.graphql") // Specify your desired package name here
    }
}


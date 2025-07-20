
# 🥁 Android Drum Simulator

An interactive and lightweight **Android drum simulator app** built with **Java** and **Android SDK**. Tap the drum pads to play various drum sounds — designed for fun, learning, and demonstration of audio playback in Android.

---

## ✨ Features

- 🥁 Simulated drum kit with multiple touchable pads
- 🔊 Instant audio playback for each drum sound
- ⚡ Responsive touch UI with low-latency sound output
- 🎨 Simple and clean layout using native Android views
- 📱 Runs smoothly on phones and tablets

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Arctic Fox or newer recommended)
- Android SDK 21+
- Java 8+

### Running the App

1. Clone the repository:
   ```bash
   git clone https://github.com/krzz1234/Android_Drum-Sim.git

2. Open the project in **Android Studio**

3. Connect an Android device or start an emulator

4. Click **Run**

---

## 📁 Project Structure

```
app/
├── java/
│   └── com.example.drumsimulator/
│       ├── MainActivity.java
│       └── utils/
│           └── SoundManager.java
├── res/
│   ├── layout/
│   │   └── activity_main.xml
│   ├── drawable/
│   └── raw/                <-- Drum sound files (.wav, .mp3)
└── AndroidManifest.xml
```

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Android SDK
* **Architecture:** Activity-based
* **Audio:** Native Android `SoundPool` API for efficient sound playback

---

## 📚 Learning Goals

This app was developed to:

* Explore Android’s native audio capabilities using `SoundPool`
* Understand how to trigger and manage sound effects on UI interaction
* Practice building a fun and interactive app without external dependencies
* Learn basic performance optimization for mobile sound-based apps

---



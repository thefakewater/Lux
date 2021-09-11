<h1 align="center">
  <br>
  <img src="https://cdn.discordapp.com/attachments/882668023062884372/886258142726463558/LUX_2.png" alt="Lux">
  <br>
  Lux
  <br>
</h1>
<h4 align="center">An Omegle bot built on top of <a href="https://www.selenium.dev/" target="_blank">Selenium</a>.</h4>
<p align="center">
  <img src="https://img.shields.io/github/last-commit/ShadowNoxX/Lux">
  <img src="https://img.shields.io/github/license/ShadowNoxX/Lux">
  <img src="https://img.shields.io/website?url=https%3A%2F%2Fwww.omegle.com%2F">
  <img src="https://img.shields.io/github/stars/ShadowNoxX/Lux">
</p>
<p align="center">
  <a href="#features">Features</a> •
  <a href="#how-to-use">How To Use</a> •
  <a href="#how-to-build">How To Build</a> •
  <a href="#download">Download</a> •
  <a href="#credits">Credits</a>
</p>

## Features
* Automatic Skip
  - Skips when user leaves.
  - Skips when all messages are sent.
* Custom messages
  - Write your own messages in messages.txt.
* Headless
  - Choose wether or not Lux should be visible.
* Fast
  - Lux is optimized for speed.
* Cross Platform
  - Windows, macOS and Linux.
* Screenshot
  - Lux will take a screenshot when conversation ends.

## How to use
To run this application, you'll need [Firefox](https://www.mozilla.org/en-US/firefox/new/), [Geckodriver to PATH](https://github.com/mozilla/geckodriver/releases) and [JRE 8](https://www.java.com/en/download/) installed on your computer. From your command line:
```bash
# Download the latest jar file from https://github.com/ShadowNoxX/Lux/releases

# Execute Jar file
$ java -jar Lux.jar
```


## How to build
To clone and build this application, you'll need [Gradle](https://gradle.org/install/) and [IntelliJ IDEA](https://www.jetbrains.com/idea/) (which comes with [Kotlin](https://kotlinlang.org/) support) installed on your computer. From your command line:
```bash
# Clone this repository
$ git clone https://github.com/ShadowNoxX/Lux.git

# Open the folder
$ cd Lux

# Gradle Setup
$ gradle wrapper
$ gradlew

# Build Jar
$ gradlew jar

Now a jar will be created in build/libs folder
```

## Download
You can [download](https://github.com/ShadowNoxX/Lux/releases/) the latest installable version of Lux for Windows, macOS and Linux.

## Credits
This software uses the following open source packages:
- [Kotlin](https://github.com/JetBrains/kotlin)
- [Selenium](https://www.selenium.dev/)
- [Gradle](https://gradle.org/)

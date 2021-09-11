package org.sithhub.omeglebot

import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.io.File
import java.io.InputStream
import org.apache.commons.io.FileUtils

const val DELAY = 2000.toLong()

@Throws(Exception::class)
fun takeSnapShot(driver: WebDriver, fileWithPath: String?) {
    val scrShot = driver as TakesScreenshot
    val srcFile = scrShot.getScreenshotAs(OutputType.FILE)
    val destFile = File(fileWithPath!!)
    FileUtils.copyFile(srcFile, destFile)
}



fun acceptTos(driver: WebDriver) : Boolean {
    try {
        driver.findElement(By.cssSelector("body > div:nth-child(15) > div:nth-child(1) > p:nth-child(2) > label:nth-child(1) > input:nth-child(1)")).click()
        driver.findElement(By.cssSelector("body > div:nth-child(15) > div:nth-child(1) > p:nth-child(3) > label:nth-child(1) > input:nth-child(1)")).click()
        driver.findElement(By.cssSelector("body > div:nth-child(15) > div:nth-child(1) > p:nth-child(4) > input:nth-child(1)")).click()
    } catch(e: Exception) {
        return false
    }
    return true
}

fun startText(driver: WebDriver) : Boolean {
    try {
        driver.findElement(By.xpath("//*[@id=\"textbtn\"]")).click()
    } catch (e: Exception) {
        return false
    }
    return true
}

fun readMessage() : String {
    return try {
        val inputStream: InputStream = File("messages.txt").inputStream()
        val content = inputStream.bufferedReader().use { it.readText() }
        content
    } catch (e: Exception) {
        print(e.toString())
        "No"
    }
}

fun sendMessage(driver: WebDriver, message: String) : Boolean {
    return try {
        driver.findElement(By.cssSelector(".chatmsg")).sendKeys(message+"\n")
        true
    } catch (e: Exception) {
        false
    }
}

fun checkAlive(driver: WebDriver) : Boolean {
    return driver.findElement(By.cssSelector(".disconnectbtn")).text == "New\nEsc"
}
fun startNew(driver: WebDriver) {
    driver.findElement(By.cssSelector(".disconnectbtn")).click()
}

fun continueNew(driver: WebDriver) {
    for (i in 1..3) {
        driver.findElement(By.cssSelector(".disconnectbtn")).click()
    }
}
fun main(args: Array<String>) {
    System.setProperty("webdriver.firefox.driver", "") // Add your geckodriver.exe to path
    val driver = FirefoxDriver()
    driver.get("https://omegle.com/")
    startText(driver)
    acceptTos(driver)
    val messages = readMessage().split(",")
    var itr: ListIterator<String>
    var i = 0
    var artificial = true
    while (true) {
        i+=1
        itr = messages.listIterator()
        while (itr.hasNext()) {
            Thread.sleep(DELAY)
            if (!checkAlive(driver)) {
                sendMessage(driver, itr.next())
                artificial = false
            } else {
                takeSnapShot(driver, "ss/snap%d.png".format(i))
                println("[LEFT] Artificial")
                startNew(driver)
                artificial = true
                break
            }
        }
        if (!artificial) {
            Thread.sleep(DELAY)
            takeSnapShot(driver, "ss/snap%d.png".format(i))
            println("[LEFT] Non-Artificial")
            continueNew(driver)
        }
    }
}
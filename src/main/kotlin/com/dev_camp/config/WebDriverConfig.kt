package com.dev_camp.config

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope
import java.util.logging.Level

@Component
class WebDriverConfig(){
    @Bean
    @RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    fun webDriver(): WebDriver {
        val chromeDriverPath = "C:\\terrace_pj\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", chromeDriverPath)
        val options = ChromeOptions()
            .addArguments("disable-gpu","--window-size=1920,1200")
            .setHeadless(true)

        val driver = ChromeDriver(options)
        driver.setLogLevel(Level.WARNING)
        return driver
    }
}
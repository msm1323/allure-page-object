package ru.msm.framework.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.msm.framework.managers.DriverManager;

public class AllureListener extends AllureJunit5 implements TestWatcher {

    DriverManager DRIVER_MANAGER = DriverManager.getINSTANCE();

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getScreenshot(){
        return ((TakesScreenshot) DRIVER_MANAGER.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
            getScreenshot();
    }

//    @Override
//    public void afterTestExecution(ExtensionContext context) {
//        if(context.getExecutionException().isPresent()){
//            getScreenshot();
//        }
//    }
}

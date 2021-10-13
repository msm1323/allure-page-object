package ru.msm.framework;

//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.msm.framework.managers.DriverManager;
import ru.msm.framework.managers.InitManager;
import ru.msm.framework.managers.PageManager;
import ru.msm.framework.managers.PropertiesManager;
import ru.msm.framework.utils.AllureListener;

import static ru.msm.framework.utils.PropertiesConstants.BASE_URL;

@ExtendWith(AllureListener.class)
public class BaseTestClass {

    /**
     * Менеджер страничек
     */
    protected PageManager PAGE_MANAGER = PageManager.getINSTANCE();

    /**
     * Менеджер WebDriver
     */
    private final DriverManager DRIVER_MANAGER = DriverManager.getINSTANCE();

    @BeforeAll//Class//All
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach//Each
    public void beforeEach() {
        DRIVER_MANAGER.getDriver().get(PropertiesManager.getINSTANCE().getProperty(BASE_URL));
    }

    @AfterAll//Class//All
    public static void afterAll() {
        InitManager.quitFramework();
    }
}

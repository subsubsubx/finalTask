package ru.ibs.framework.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;

public class Hooks {
    final static DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void  beforeAll() {
        InitManager.initFramework();
        driverManager
                .getDriver()
                .get(DriverEnums.BASE_URL.getValue());
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}

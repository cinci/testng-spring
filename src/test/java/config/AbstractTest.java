package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import service.SimpleService;

/**
 * Created by jc on 19. 5. 2015.
 */
@ContextConfiguration(classes = {TestConfig.class})
@TestExecutionListeners(inheritListeners = false,
        listeners = {
                DependencyInjectionTestExecutionListener.class,
                DirtiesContextTestExecutionListener.class
        })
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SimpleService simpleService;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("--> Before Class: " + this.getClass().getName());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
        System.out.println("--> After Class: " + this.getClass().getName());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
        System.out.println("--> After Suite: " + this.getClass().getName());

        if(simpleService == null) {
            System.out.println("Spring configuration FAILED !!!");
        }
    }
}

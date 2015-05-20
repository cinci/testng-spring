package test;

import config.TestGroups;
import org.testng.annotations.Test;

/**
 * Created by jc on 22. 4. 2015.
 */
public class TestOne extends AbstractTest {

    @Test(groups = {TestGroups.DISABLE_IN_RUNTIME, TestGroups.UNIT})
    public void test() {
        System.out.println("... testing ...");
    }
}

package test;

import config.AbstractTest;
import config.TestGroups;
import org.testng.annotations.Test;

/**
 * Created by jc on 22. 4. 2015.
 */
public class TestTwo extends AbstractTest {

    @Test(groups = {TestGroups.UNIT})
    public void test() {
        System.out.println("... testing ...");
    }
}

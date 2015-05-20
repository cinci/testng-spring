package listener;

import config.TestGroups;
import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jc on 19. 5. 2015.
 */
public class AnnotationTransformer implements IAnnotationTransformer2 {
    @Override
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    }

    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
    }

    @Override
    public void transform(IFactoryAnnotation annotation, Method method) {
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        final List<String> groups = Arrays.asList(annotation.getGroups());

        // annotation.setEnabled(false);

        if (groups.contains(TestGroups.DISABLE_IN_RUNTIME)) {
            annotation.setEnabled(false);
        }
    }
}

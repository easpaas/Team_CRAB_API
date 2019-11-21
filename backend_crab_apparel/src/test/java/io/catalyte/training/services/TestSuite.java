package io.catalyte.training.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerServiceImplTest.class,
        ProductServiceImplTest.class,
})
public class TestSuite {
}


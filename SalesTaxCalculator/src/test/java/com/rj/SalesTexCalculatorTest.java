package com.rj;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ItemTest.class,CartTest.class})
@SpringBootTest
public class SalesTexCalculatorTest {

}

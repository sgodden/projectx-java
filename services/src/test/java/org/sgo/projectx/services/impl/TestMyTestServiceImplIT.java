package org.sgo.projectx.services.impl;

import org.sgo.projectx.services.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:org/sgo/projectx/services/beans.xml"})
public class TestMyTestServiceImplIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private MyTestService myTestService;

    @Test
    public void basicTest() {
        myTestService.doSomeStuff();
        myTestService.doMoreStuff();
    }

}

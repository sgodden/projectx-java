package org.sgo.projectx.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:org/sgo/projectx/persistence/beans.xml"})
public class BasicTestIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void basicTest() {
        Assert.assertNotNull(ctx);
    }

}

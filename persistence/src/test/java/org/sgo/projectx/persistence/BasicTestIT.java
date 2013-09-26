package org.sgo.projectx.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.persistence.EntityManagerFactory;

@ContextConfiguration(locations={"classpath:org/sgo/projectx/persistence/beans.xml"})
@Transactional
public class BasicTestIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private org.sgo.projectx.persistence.Test test;

    @Test
    public void basicTest() {
        test.testIt1();
        test.testIt2();
    }

}

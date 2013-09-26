package org.sgo.projectx.services;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MyTestService {

    void doSomeStuff();

    void doMoreStuff();

}

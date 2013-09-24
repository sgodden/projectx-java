package org.sgo.projectx.model;

import org.sgodden.tom.model.ICustomer;

public class Customer extends AbstractIdentity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

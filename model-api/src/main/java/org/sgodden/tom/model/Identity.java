package org.sgodden.tom.model;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.io.Serializable;

public interface Identity extends Serializable {

    String getId();

    default boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Identity other = (Identity) o;

        if (other.getId() == null || getId() == null) {
            return other == this; // default to whether they are the same object pointer
        }
        else {
            return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
        }
    };

}

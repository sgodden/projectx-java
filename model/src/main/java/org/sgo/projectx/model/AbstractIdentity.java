package org.sgo.projectx.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

public abstract class AbstractIdentity implements Serializable {

    private String id;

    private Long version;

    public String getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof AbstractIdentity)) {
            return false;
        }

        AbstractIdentity o = (AbstractIdentity) other;

        if (getId() == null || o.getId() == null) {
            return super.equals(other);
        }

        return new EqualsBuilder()
            .append(this.getId(), o.getId())
            .isEquals();
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            return super.hashCode();
        }

        return new HashCodeBuilder(23, 61)
            .append(getId())
            .toHashCode();
    }
}
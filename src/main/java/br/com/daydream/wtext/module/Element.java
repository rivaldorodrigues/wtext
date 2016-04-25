package br.com.daydream.wtext.module;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Rivaldo on 23/04/16.
 */
public abstract class Element {

    protected String element;

    protected Element(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }
}

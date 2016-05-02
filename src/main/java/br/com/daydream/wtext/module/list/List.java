package br.com.daydream.wtext.module.list;

import br.com.daydream.wtext.markup.ListType;
import br.com.daydream.wtext.arq.module.Element;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Rivaldo on 30/04/16.
 */
public class List extends Element {

    List(String element) {
        super(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof List)) return false;

        List other = (List) o;

        return new EqualsBuilder()
                .append(element, other.element)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(element)
                .toHashCode();
    }
}

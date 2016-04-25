package br.com.daydream.wtext.module.table;

import br.com.daydream.wtext.module.Element;
import br.com.daydream.wtext.module.link.Link;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author rivaldo
 * Created on 25/04/2016.
 */
public class Cell extends Element {

    public Cell(String element) {
        super(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Cell)) return false;

        Cell other = (Cell) o;

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

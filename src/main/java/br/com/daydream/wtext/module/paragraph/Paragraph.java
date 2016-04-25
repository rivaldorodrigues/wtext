package br.com.daydream.wtext.module.paragraph;

import br.com.daydream.wtext.module.Element;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Rivaldo on 23/04/16.
 */
public class Paragraph extends Element {

    Paragraph(String element) {
        super(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Paragraph)) return false;

        Paragraph other = (Paragraph) o;

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

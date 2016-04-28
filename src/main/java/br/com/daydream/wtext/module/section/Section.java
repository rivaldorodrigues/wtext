package br.com.daydream.wtext.module.section;

import br.com.daydream.wtext.module.paragraph.Paragraph;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author rivaldo
 *         Created on 26/04/2016.
 */
public class Section extends Paragraph {

    public Section(String element) {
        super(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Section)) return false;

        Section other = (Section) o;

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

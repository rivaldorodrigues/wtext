package br.com.daydream.wtext.arq.module;

import br.com.daydream.wtext.arq.formatter.TextFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class Text extends Element {

    public Text(String text) {
        super(text);
    }

    public Text(String text, TextFormat format) {
        super(text);
        format(format);
    }

    protected void format(TextFormat format) {
        element = format.apply(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Text)) return false;

        Text other = (Text) o;

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

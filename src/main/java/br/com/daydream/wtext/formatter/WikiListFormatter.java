package br.com.daydream.wtext.formatter;

import br.com.daydream.wtext.arq.formatter.LinkFormatter;
import br.com.daydream.wtext.arq.formatter.ListFormatter;
import br.com.daydream.wtext.markup.ListType;
import br.com.daydream.wtext.module.list.ListBuilder;
import br.com.daydream.wtext.module.list.ListItem;

import java.util.Collection;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiListFormatter implements ListFormatter {

    @Override
    public String ordered(Collection<ListItem> itens) {
        return format(itens, ListType.ORDERED);
    }

    @Override
    public String unordered(Collection<ListItem> itens) {
        return format(itens, ListType.UNORDERED);
    }

    private String format(Collection<ListItem> itens, ListType type) {
        StringBuilder sBuilder = new StringBuilder();
        itens.forEach(item -> sBuilder.append(type.apply(item.getLevel(), item.toString())));

        return sBuilder.toString();
    }
}

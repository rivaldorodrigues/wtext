package br.com.daydream.wtext.module.list;

import br.com.daydream.wtext.arq.formatter.FormatterFactory;
import br.com.daydream.wtext.arq.formatter.ListFormatter;
import br.com.daydream.wtext.arq.module.Text;
import br.com.daydream.wtext.markup.ListType;
import br.com.daydream.wtext.arq.module.Element;
import com.google.common.collect.Lists;
import com.sun.istack.internal.NotNull;

import java.util.Collection;

/**
 * Created by Rivaldo on 30/04/16.
 */
public class ListBuilder {

    private static final int DEFAULT_LEVEL = 1;

    private Collection<ListItem> itens = Lists.newArrayList();

    private static ListFormatter formatter = FormatterFactory.getListFormatter();

    public ListBuilder addItem(@NotNull String text) {
        return addItem(DEFAULT_LEVEL, text);
    }

    public ListBuilder addItem(int level, @NotNull String text) {
        itens.add(new ListItem(level, text));
        return this;
    }

    public ListBuilder addItem(@NotNull Text text) {
        return addItem(DEFAULT_LEVEL, text);
    }

    public ListBuilder addItem(int level, @NotNull Text text) {
        itens.add(new ListItem(level, text));
        return this;
    }

    public List buildUnorderedList() {
        return new List(formatter.unordered(itens));
    }

    public List buildOrderedList() {
        return new List(formatter.ordered(itens));
    }

}

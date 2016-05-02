package br.com.daydream.wtext.arq.formatter;

import br.com.daydream.wtext.module.list.ListItem;

import java.util.Collection;

/**
 * Created by Rivaldo on 01/05/16.
 */
public interface ListFormatter {

    String ordered(Collection<ListItem> itens);

    String unordered(Collection<ListItem> itens);
}

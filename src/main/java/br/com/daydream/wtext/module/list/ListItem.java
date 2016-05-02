package br.com.daydream.wtext.module.list;

import br.com.daydream.wtext.arq.module.Element;
import br.com.daydream.wtext.arq.module.Text;
import com.sun.istack.internal.NotNull;

/**
 * Created by Rivaldo on 30/04/16.
 */
public class ListItem extends Text {

    int level;

    public ListItem(int level, @NotNull String item) {
        super(item);
        this.level = (level > 0) ? level : 1;
    }

    public ListItem(int level, @NotNull Text item) {
        super(item.toString());
        this.level = (level > 0) ? level : 1;
    }

    public int getLevel() {
        return level;
    }
}

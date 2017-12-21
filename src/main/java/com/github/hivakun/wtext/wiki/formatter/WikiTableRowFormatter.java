package com.github.hivakun.wtext.wiki.formatter;

/*
 * #%L
 * WText
 * %%
 * Copyright (C) 2016 Rivaldo Rodrigues
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.github.hivakun.wtext.arq.formatter.TableRowFormatter;
import com.github.hivakun.wtext.module.table.Table;
import com.github.hivakun.wtext.wiki.markup.WikiTableMarkup;
import org.jetbrains.annotations.NotNull;

/**
 * Implements the mediawiki table formatting strategy.
 *
 * @author hivakun
 * Created on 04/05/16
 * @see Table
 */
public class WikiTableRowFormatter implements TableRowFormatter {

    @Override
    public String style(@NotNull String val) {
        return WikiTableMarkup.STYLE.apply(val);
    }

    @Override
    public String backgroundColor(@NotNull String val) {
        return WikiTableMarkup.BACKGROUND_COLOR.apply(val);
    }
}

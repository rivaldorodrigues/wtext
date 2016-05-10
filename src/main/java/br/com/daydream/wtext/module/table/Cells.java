package br.com.daydream.wtext.module.table;

/*
 * #%L
 * WText
 * %%
 * Copyright (C) 2016 Daydream
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


import br.com.daydream.wtext.arq.module.Text;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author rivaldo
 * Created on 26/04/2016.
 */
public class Cells {

    public static Cell newCell(String text) {
        return new Cell(text);
    }

    public static Cell newCell(@NotNull Text text) {
        return new Cell(text.toString());
    }

    public static List<Cell> newCellRow(String... text) {
        return stringToCell(text);
    }

    public static List<Cell> newCellRow(Text... text) {
        return textToCell(text);
    }

    private static List<Cell> stringToCell(String... rows) {

        List<Cell> cells = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(rows)) {
            for (String item : rows) {
                cells.add(new Cell(item));
            }
        }

        return cells;
    }

    private static List<Cell> textToCell(Text... rows) {

        List<Cell> cells = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(rows)) {
            for (Text item : rows) {
                cells.add(new Cell(item.toString()));
            }
        }

        return cells;
    }
}

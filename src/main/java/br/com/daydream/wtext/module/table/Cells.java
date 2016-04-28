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


import br.com.daydream.wtext.markup.table.CellType;
import br.com.daydream.wtext.module.Element;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author rivaldo
 * Created on 26/04/2016.
 */
public class Cells {

    public static Cell newTableCaption(String caption) {
        return new Cell(caption, CellType.CAPTION);
    }

    public static Cell newTableCaption(@NotNull Element caption) {
        return new Cell(caption.toString(), CellType.CAPTION);
    }

    public static Cell newTableHeaderCell(String header) {
        return new Cell(header, CellType.HEADER);
    }

    public static Cell newTableHeaderCell(@NotNull Element header) {
        return new Cell(header.toString(), CellType.HEADER);
    }

    public static List<Cell> newTableHeader(String... header) {
        return stringToCell(CellType.HEADER, header);
    }

    public static List<Cell> newTableHeader(Element... header) {
        return elementToCell(CellType.HEADER, header);
    }

    public static Cell newTableCell(String cell) {
        return new Cell(cell, CellType.DATA);
    }

    public static Cell newTableCell(@NotNull Element cell) {
        return new Cell(cell.toString(), CellType.DATA);
    }

    public static List<Cell> newTableRow(String... rows) {
        return stringToCell(CellType.DATA, rows);
    }

    public static List<Cell> newTableRow(Element... rows) {
        return elementToCell(CellType.DATA, rows);
    }

    private static List<Cell> stringToCell(CellType type, String... rows) {

        List<Cell> cells = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(rows)) {
            for (String item : rows) {
                cells.add(new Cell(item, type));
            }
        }

        return cells;
    }

    private static List<Cell> elementToCell(CellType type, Element... rows) {

        List<Cell> cells = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(rows)) {
            for (Element item : rows) {
                cells.add(new Cell(item.toString(), type));
            }
        }

        return cells;
    }
}

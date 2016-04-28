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


import br.com.daydream.wtext.markup.table.TableParameter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author rivaldo
 * Created on 25/04/2016.
 */
public class TableBuilder {

    List<Cell> header;
    Cell caption = null;
    List<List<Cell>> rows = Lists.newArrayList();

    Map<TableParameter, Object> parameters = Maps.newHashMap();

    public TableBuilder() {
        this.header = Lists.newArrayList();
        addDefaultParameters();
    }

    public TableBuilder(List<Cell> header) {
        this.header = header;
        addDefaultParameters();
    }

    public TableBuilder withHeader(List<Cell> val) {
        this.header = val;
        return this;
    }

    public TableBuilder withCaption(Cell val) {
        this.caption = val;
        return this;
    }

    public TableBuilder addHeader(Cell val) {
        header.add(val);
        return this;
    }

    public TableBuilder addNewRow(List<Cell> row) {
        this.rows.add(row);
        return this;
    }

    public TableBuilder addNewCell(int rowIndex, Cell cell) {
        this.rows.get(rowIndex).add(cell);
        return this;
    }

    public TableBuilder withBorder(int val) {
        parameters.put(TableParameter.BORDER, val);
        return this;
    }

    public TableBuilder withCellpadding(int val) {
        parameters.put(TableParameter.CELL_PADDING, val);
        return this;
    }

    public TableBuilder withCellspacing(int val) {
        parameters.put(TableParameter.CELL_SPACING, val);
        return this;
    }

    public boolean isEmptyTable() {
        return header.isEmpty() && rows.isEmpty();
    }

    public Table build() {
        return new Table(this);
    }

    private void addDefaultParameters() {
        withBorder(1);
        withCellpadding(2);
        withCellspacing(0);
    }
}

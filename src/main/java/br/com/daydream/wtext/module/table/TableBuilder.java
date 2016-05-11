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


import br.com.daydream.wtext.arq.formatter.FormatterFactory;
import br.com.daydream.wtext.arq.formatter.TableFormatter;
import br.com.daydream.wtext.arq.parameter.TableParameter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Builder class to create table.
 * @see Table
 *
 * @author hivakun
 * Created on 25/04/16
 */
public class TableBuilder {

    private List<Cell> header;
    private String caption = null;
    private List<List<Cell>> rows = Lists.newArrayList();

    private Map<TableParameter, Object> parameters = Maps.newHashMap();

    private TableFormatter formatter = FormatterFactory.getTableFormatter();

    /**
     * Create the table builder.
     */
    public TableBuilder() {
        this.header = Lists.newArrayList();
        addDefaultParameters();
    }

    /**
     * Create the table builder with the desired header.
     *
     * @param header the table header
     */
    public TableBuilder(List<Cell> header) {
        this.header = header;
        addDefaultParameters();
    }

    /**
     * Define the table header.
     *
     * @param val the desired table header
     * @return the builder itself
     */
    public TableBuilder withHeader(List<Cell> val) {
        this.header = val;
        return this;
    }

    /**
     * Define the table caption.
     *
     * @param val the desired table caption
     * @return the builder itself
     */
    public TableBuilder withCaption(String val) {
        this.caption = val;
        return this;
    }

    /**
     * Add the desired cell to the table header.
     *
     * @param val the cell to be appended to the header
     * @return the builder itself
     */
    public TableBuilder addHeader(Cell val) {
        header.add(val);
        return this;
    }

    /**
     * Add a new row to the table.
     * @param row the cell list representing the row
     *
     * @return the builder itself
     */
    public TableBuilder addNewRow(List<Cell> row) {
        this.rows.add(row);
        return this;
    }

    /**
     * Add a cell to a specific table row.
     *
     * @param rowIndex the index of the row
     * @param cell the cell to be appended
     * @return the builder itself
     */
    public TableBuilder addNewCell(int rowIndex, Cell cell) {
        this.rows.get(rowIndex).add(cell);
        return this;
    }

    /**
     * Define the table border.
     *
     * @param val the desired table border
     * @return the builder itself
     */
    public TableBuilder withBorder(int val) {
        parameters.put(TableParameter.BORDER, val);
        return this;
    }

    /**
     * Define the table cell padding.
     *
     * @param val the desired table cell padding
     * @return the builder itself
     */
    public TableBuilder withCellpadding(int val) {
        parameters.put(TableParameter.CELL_PADDING, val);
        return this;
    }

    /**
     * Define the table cell spacing.
     *
     * @param val the desired table cell spacing
     * @return the builder itself
     */
    public TableBuilder withCellspacing(int val) {
        parameters.put(TableParameter.CELL_SPACING, val);
        return this;
    }

    /**
     * Checks if the table has no element (header or rows).
     *
     * @return true if the table has no elements, false otherwise
     */
    public boolean isEmptyTable() {
        return header.isEmpty() && rows.isEmpty();
    }

    /**
     * Create a table.
     *
     * @return the table element
     */
    public Table buildTable() {
        return new Table(formatter.formatTable(header,caption,rows,parameters));
    }

    /**
     * Initialize the table with default parameters.
     */
    private void addDefaultParameters() {
        withBorder(1);
        withCellpadding(2);
        withCellspacing(0);
    }
}

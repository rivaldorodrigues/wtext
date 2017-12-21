package com.github.hivakun.wtext.module.table;

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


import com.github.hivakun.wtext.arq.module.DataContainer;
import com.github.hivakun.wtext.arq.parameter.TableCellParameter;
import com.github.hivakun.wtext.arq.parameter.TableParameter;
import com.github.hivakun.wtext.arq.parameter.TableRowParameter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Represents a table row at the document.
 *
 * @author hivakun
 * Created on 10/10/16
 */
public class Row implements DataContainer {

    private List<Cell> row = Collections.EMPTY_LIST;
    private Map<TableRowParameter, String> parameters = Maps.newHashMap();

    /**
     * Create a new table row element.
     *
     * @param cells the array of cells that represents the row columns
     */
    protected Row(@NotNull List<Cell> cells) {
        this.row = cells;
    }

    /**
     * Create a new table row element with the desired row parameter.
     *
     * @param parameter the parameter for the row
     * @param cells     the array of cells that represents the row columns
     */
    protected Row(Map<TableRowParameter, String> parameters, @NotNull List<Cell> cells) {
        this.parameters = parameters;
        this.row = cells;
    }

    public void addCell(@NotNull Cell cell) {
        row.add(cell);
    }

    public boolean isEmpty() {
        return row.isEmpty();
    }

    public Map<TableRowParameter, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<TableRowParameter, String> parameters) {
        this.parameters = parameters;
    }

    public void setParameter(TableRowParameter parameter, @NotNull String paramValue) {
        parameters.put(parameter, paramValue);
    }

    public String setParameter(TableRowParameter parameter) {
        return parameters.get(parameter);
    }

    public List<Cell> getRowAsList() {
        return Collections.unmodifiableList(row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Row)) return false;

        Row other = (Row) o;

        return new EqualsBuilder()
                .append(row, other.row)
                .append(parameters, other.parameters)
                .isEquals();
    }
}

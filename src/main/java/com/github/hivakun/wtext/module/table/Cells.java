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


import com.github.hivakun.wtext.arq.module.Text;
import com.github.hivakun.wtext.arq.parameter.TableCellParameter;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * Factory class to create cells.
 *
 * @author hivakun
 * Created on 26/04/16
 * @see Cell
 */
public class Cells {

    /**
     * Create a new cell.
     *
     * @param text the cell text
     * @return the cell element that contains the desired text
     */
    public static Cell newCell(String text) {
        return new Cell(text);
    }

    /**
     * Create a new cell with the desired column parameter.
     *
     * @param parameter the column parameter for the cell
     * @param text      the cell text
     * @return the cell element that contains the desired text
     */
    public static Cell newCell(String text, TableCellParameter parameter, @NotNull String paramValue) {
        Cell cell = new Cell(text);
        cell.setParameter(parameter, paramValue);
        return cell;
    }

    /**
     * Create a new cell with the desired column parameter.
     *
     * @param parameter the column parameter for the cell
     * @param text      the cell text
     * @return the cell element that contains the desired text
     */
    public static Cell newCell(@NotNull Text text) {
        return new Cell(text.toString());
    }

    /**
     * Create a new cell.
     *
     * @param text the cell text
     * @return the cell element that contains the desired text
     */
    public static Cell newCell(@NotNull Text text, TableCellParameter parameter, @NotNull String paramValue) {
        Cell cell = new Cell(text.toString());
        cell.setParameter(parameter, paramValue);
        return cell;
    }

    public static class Builder {

        private String element;
        private final Map<TableCellParameter, String> parameters = Maps.newHashMap();

        public Builder(String text) {
            this.element = text;
        }

        public Builder(@NotNull Text text) {
            this.element = text.toString();
        }

        public Builder withColspan(int value) {
            this.parameters.put(TableCellParameter.COLSPAN, String.valueOf(value));
            return this;
        }

        public Builder withRowspan(int value) {
            this.parameters.put(TableCellParameter.ROWSPAN, String.valueOf(value));
            return this;
        }

        public Builder withBackgroundColor(String value) {
            this.parameters.put(TableCellParameter.BACKGROUND_COLOR, value);
            return this;
        }

        public Builder with(TableCellParameter parameter, String value) {
            this.parameters.put(parameter, value);
            return this;
        }

        public Cell build() {
            return new Cell(element, parameters);
        }
    }

}

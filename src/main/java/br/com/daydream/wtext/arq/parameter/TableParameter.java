package br.com.daydream.wtext.arq.parameter;

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

/**
 * Enum that hold all the parameters that can be applied in a table element.
 * @see TableFormatter
 *
 * @author hivakun
 * Created on 25/04/16
 */
public enum TableParameter {

    BORDER() {
        @Override
        public String apply(Object val) {
            return formatter.border(val);
        }
    },

    CELL_PADDING() {
        @Override
        public String apply(Object val) {
            return formatter.cellPadding(val);
        }
    },

    CELL_SPACING() {
        @Override
        public String apply(Object val) {
            return formatter.cellSpacing(val);
        }
    };

    final TableFormatter formatter;

    /**
     * Creates the constants of table parameters.
     */
    TableParameter() {
        formatter = FormatterFactory.getTableFormatter();
    }

    /**
     * Apply the desired value to the specified table parameter.
     *
     * @param val the desired value
     * @return the markup text of the table parameter with the desired value
     */
    public abstract String apply(Object val);
}

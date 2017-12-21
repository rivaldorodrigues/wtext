package com.github.hivakun.wtext.arq.parameter;

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


import com.github.hivakun.wtext.arq.formatter.FormatterController;
import com.github.hivakun.wtext.arq.formatter.TableFormatter;
import com.github.hivakun.wtext.arq.formatter.TableRowFormatter;

/**
 * Enum that hold all the parameters that can be applied in a table element.
 * @see TableFormatter
 *
 * @author hivakun
 * Created on 11/10/16
 */
public enum TableRowParameter {

    STYLE() {
        @Override
        public String apply(String val) {
            return formatter.style(val);
        }
    },


    BACKGROUND_COLOR() {
        @Override
        public String apply(String val) {
            return formatter.backgroundColor(val);
        }
    };

    final TableRowFormatter formatter;

    /**
     * Creates the constants of table parameters.
     */
    TableRowParameter() {
        formatter = FormatterController.getFactory().getTableRowFormatter();
    }

    /**
     * Apply the desired value to the specified table parameter.
     *
     * @param val the desired value
     * @return the markup text of the table parameter with the desired value
     */
    public abstract String apply(String val);
}

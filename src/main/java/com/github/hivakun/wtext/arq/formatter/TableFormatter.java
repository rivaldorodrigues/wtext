package com.github.hivakun.wtext.arq.formatter;

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

import com.github.hivakun.wtext.arq.parameter.TableParameter;
import com.github.hivakun.wtext.module.table.Row;
import com.github.hivakun.wtext.module.table.Table;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Interface to all classes that implement the table formatting strategy.
 * @see Table
 *
 * @author hivakun
 * Created on 04/05/16
 */
public interface TableFormatter {

    /**
     * Apply the desired value to the table tableBorder parameter.
     *
     * @param val the desired value
     * @return the markup text of the table tableBorder parameter with the desired value
     */
    String tableBorder(@NotNull Object val);

    /**
     * Apply the desired value to the table cell padding parameter.
     *
     * @param val the desired value
     * @return the markup text of the table cell padding parameter with the desired value
     */
    String cellPadding(@NotNull Object val);

    /**
     * Apply the desired value to the table cell spacing parameter.
     *
     * @param val the desired value
     * @return the markup text of the table cell spacing parameter with the desired value
     */
    String cellSpacing(@NotNull Object val);

    /**
     * Apply the desired value to the table class parameter.
     *
     * @param val the desired value
     * @return the markup text of the table class parameter with the desired value
     */
    String tableClass(@NotNull Object val);

    /**
     * Apply the desired value to the table cell spacing parameter.
     *
     * @param val the desired value
     * @return the markup text of the table cell spacing parameter with the desired value
     */
    String style(@NotNull Object val);

    /**
     * Format the table and apply the specified parameters.
     *
     * @param header the table header line
     * @param caption the table caption
     * @param rows the list of table rows
     * @param param an map with all the desired parameters
     * @param tableClasses the css classes to be applied to the table
     * @return a string formatted with the table markup
     */
    String formatTable(Row header, String caption, List<Row> rows, Map<TableParameter, Object> param, List<String> tableClasses);
}

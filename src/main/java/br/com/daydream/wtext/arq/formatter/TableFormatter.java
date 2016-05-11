package br.com.daydream.wtext.arq.formatter;

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


import br.com.daydream.wtext.arq.parameter.TableParameter;
import br.com.daydream.wtext.module.table.Cell;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Interface to all classes that implement the table formatting strategy.
 * @see br.com.daydream.wtext.module.table.Table
 *
 * @author hivakun
 * Created on 04/05/16
 */
public interface TableFormatter {

    /**
     * Apply the desired value to the table border parameter.
     *
     * @param val the desired value
     * @return the markup text of the table border parameter with the desired value
     */
    String border(@NotNull Object val);

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
     * Format the table and apply the specified parameters.
     *
     * @param header the table header line
     * @param caption the table caption
     * @param rows the list of table rows
     * @param param an map with all the desired parameters
     * @return a string formatted with the table markup
     */
    String formatTable(List<Cell> header, String caption, List<List<Cell>> rows, Map<TableParameter, Object> param);
}

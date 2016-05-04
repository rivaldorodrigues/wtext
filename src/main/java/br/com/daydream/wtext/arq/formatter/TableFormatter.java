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

import java.util.List;
import java.util.Map;

/**
 * @author rivaldo
 *         Created on 04/05/2016.
 */
public interface TableFormatter {

    String border(Object text);
    String cellPadding(Object text);
    String cellSpacing(Object text);

    String formatTable(List<Cell> header, Cell caption, List<List<Cell>> rows, Map<TableParameter, Object> parameters);
}

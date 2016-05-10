package br.com.daydream.wtext.wiki.formatter;

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


import br.com.daydream.wtext.arq.formatter.TableFormatter;
import br.com.daydream.wtext.arq.parameter.TableParameter;
import br.com.daydream.wtext.wiki.markup.WikiTableMarkup;
import br.com.daydream.wtext.module.table.Cell;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Implements the mediawiki table formatting strategy.
 * @see br.com.daydream.wtext.module.table.Table
 *
 * @author hivakun
 * Created on 04/05/16
 */
public class WikiTableFormatter implements TableFormatter {

    @Override
    public String border(@NotNull Object text) {
        return WikiTableMarkup.BORDER.apply(text.toString());
    }

    @Override
    public String cellPadding(@NotNull Object text) {
        return WikiTableMarkup.CELL_PADDING.apply(text.toString());
    }

    @Override
    public String cellSpacing(@NotNull Object text) {
        return WikiTableMarkup.CELL_SPACING.apply(text.toString());
    }

    @Override
    public String formatTable(List<Cell> header, Cell caption, List<List<Cell>> rows, Map<TableParameter, Object> parameters) {

        StringBuilder sBuilder = new StringBuilder(initTableAndStyle(parameters));

        sBuilder.append(addCaption(caption));
        sBuilder.append(addHeader(header));
        sBuilder.append(addRows(rows));

        return WikiTableMarkup.TABLE_END.apply(sBuilder.toString());
    }

    /**
     * Initialize the table markup with the specified parameters.
     *
     * @param param the desired parameters
     * @return a string formatted with the source markup
     */
    private String initTableAndStyle(Map<TableParameter, Object> param) {

        StringBuilder sBuilder = new StringBuilder();

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(" ").append(k.apply(v)));
        }

        return WikiTableMarkup.TABLE_START.apply(sBuilder.toString());
    }

    /**
     * Add a caption to the table.
     *
     * @param caption the desired caption
     * @return a string formatted with the caption markup
     */
    private String addCaption(Cell caption) {
        return caption == null ? "" : WikiTableMarkup.CAPTION.apply(caption.toString());
    }

    /**
     * Add an header to the table.
     *
     * @param header the desired header row
     * @return a string formatted with the header markup
     */
    private String addHeader(List<Cell> header) {
        return iterateCellList(header, WikiTableMarkup.HEADER);
    }

    /**
     * Add a list of rows to the table.
     *
     * @param rows the list of rows
     * @return a string formatted with the row markup
     */
    private String addRows(List<List<Cell>> rows) {

        String result = "";

        if (CollectionUtils.isNotEmpty(rows)) {
            StringBuilder sBuilder = new StringBuilder();
            rows.forEach(row -> sBuilder.append(addRow(row)));
            result = sBuilder.toString();
        }

        return result;
    }

    /**
     * Add a single row to the table.
     *
     * @param row the desired row
     * @return a string formatted with the row markup
     */
    private String addRow(List<Cell> row) {

        String result = iterateCellList(row, WikiTableMarkup.DATA);

        if (StringUtils.isNotEmpty(result)) {
            result = WikiTableMarkup.ROW.apply(result);
        }

        return result;
    }

    /**
     * Iterate through a list of cell and format it with a specific type.
     *
     * @param data a list of cells that represents a row
     * @param type the cell type
     * @return a string formatted with the row type markup
     */
    private String iterateCellList(List<Cell> data, WikiTableMarkup type) {

        StringBuilder sBuilder = new StringBuilder();

        if (CollectionUtils.isNotEmpty(data)) {
            data.stream().filter(Objects::nonNull).forEach(item -> sBuilder.append(type.apply(item.toString())));
        }

        return sBuilder.toString();
    }
}

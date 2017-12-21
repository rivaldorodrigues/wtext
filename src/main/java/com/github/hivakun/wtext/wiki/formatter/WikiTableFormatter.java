package com.github.hivakun.wtext.wiki.formatter;

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


import com.github.hivakun.wtext.arq.formatter.TableFormatter;
import com.github.hivakun.wtext.arq.parameter.TableParameter;
import com.github.hivakun.wtext.module.table.Cell;
import com.github.hivakun.wtext.module.table.Row;
import com.github.hivakun.wtext.module.table.Table;
import com.github.hivakun.wtext.wiki.markup.WikiTableMarkup;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.awt.SystemColor.text;

/**
 * Implements the mediawiki table formatting strategy.
 * @see Table
 *
 * @author hivakun
 * Created on 04/05/16
 */
public class WikiTableFormatter implements TableFormatter {

    private static final String PARAMETER_SEPARATOR = " ";

    private static final String COLUMN_PARAMETER_SEPARATOR = "|";

    private static final String COLUMN_CELL_SEPARATOR = "||";

    @Override
    public String tableBorder(@NotNull Object text) {
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
    public String tableClass(@NotNull Object text) {
        return WikiTableMarkup.TABLE_CLASS.apply(text.toString());
    }

    @Override
    public String style(@NotNull Object val) {
        return WikiTableMarkup.STYLE.apply(text.toString());
    }

    @Override
    public String formatTable(Row header, String caption, List<Row> rows, Map<TableParameter, Object> parameters, List<String> tableClasses) {

        StringBuilder sBuilder = new StringBuilder(initTableAndStyle(parameters, tableClasses));

        sBuilder.append(addCaption(caption));
        sBuilder.append(addHeader(header));
        sBuilder.append(addRows(rows));

        return WikiTableMarkup.TABLE_END.apply(sBuilder.toString());
    }

    /**
     * Initialize the table markup with the specified parameters.
     *
     * @param param the desired parameters
     * @param tableClasses the css classes to be applied to the table
     * @return a string formatted with the source markup
     */
    private String initTableAndStyle(Map<TableParameter, Object> param, List<String> tableClasses) {

        StringBuilder sBuilder = new StringBuilder();

        if (CollectionUtils.isNotEmpty(tableClasses)) {
            sBuilder.append(PARAMETER_SEPARATOR).append(WikiTableMarkup.TABLE_CLASS.apply(String.join(PARAMETER_SEPARATOR, tableClasses)));
        }

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(PARAMETER_SEPARATOR).append(k.apply(v)));
        }

        return WikiTableMarkup.TABLE_START.apply(sBuilder.toString());
    }

    /**
     * Add a caption to the table.
     *
     * @param caption the desired caption
     * @return a string formatted with the caption markup
     */
    private String addCaption(String caption) {
        return StringUtils.isNoneBlank(caption) ? "" : WikiTableMarkup.CAPTION.apply(caption);
    }

    /**
     * Add an header to the table.
     *
     * @param header the desired header row
     * @return a string formatted with the header markup
     */
    private String addHeader(Row header) {
        return createHeader(header);
    }

    /**
     * Add a list of rows to the table.
     *
     * @param rows the list of rows
     * @return a string formatted with the row markup
     */
    private String addRows(List<Row> rows) {

        String result = "";

        if (CollectionUtils.isNotEmpty(rows)) {
            StringBuilder sBuilder = new StringBuilder();
            rows.forEach(row -> sBuilder.append(createRow(row)));
            result = sBuilder.toString();
        }

        return result;
    }

    private String createHeader(@NotNull Row data) {

        StringBuilder sBuilder = new StringBuilder();

        if (CollectionUtils.isNotEmpty(data.getRowAsList())) {
            data.getRowAsList().stream().filter(Objects::nonNull).forEach(item -> sBuilder.append(WikiTableMarkup.HEADER.apply(cellToString(item))));
        }

        return sBuilder.toString();
    }

    private String createRow(@NotNull Row row) {
        StringBuilder sBuilder = new StringBuilder(initRow(row));
        String rowData = WikiTableMarkup.ROW_DATA.apply(String.join(COLUMN_CELL_SEPARATOR, cellToString(row.getRowAsList())));

        sBuilder.append(rowData);
        return WikiTableMarkup.ROW_END.apply(sBuilder.toString());
    }

    private String initRow(@NotNull Row row) {

        StringBuilder sBuilder = new StringBuilder();

        if (MapUtils.isNotEmpty(row.getParameters())) {
            row.getParameters().forEach((k, v) -> sBuilder.append(PARAMETER_SEPARATOR).append(k.apply(v)));
        }

        return WikiTableMarkup.ROW_START.apply(sBuilder.toString());
    }

    private String cellToString(@NotNull Cell cell) {
        StringBuilder sBuilder = new StringBuilder("");

        if (MapUtils.isNotEmpty(cell.getParameters())) {
            cell.getParameters().forEach((k, v) -> sBuilder.append(PARAMETER_SEPARATOR).append(k.apply(v)));
            sBuilder.append(COLUMN_PARAMETER_SEPARATOR);
        }

        return sBuilder.append(cell.toString()).toString();
    }

    private List<String> cellToString(@NotNull List<Cell> cells) {
        List<String> values = Lists.newArrayList();
        cells.stream().filter(Objects::nonNull).forEach(cell -> values.add(cellToString(cell)));
        return values;
    }
}

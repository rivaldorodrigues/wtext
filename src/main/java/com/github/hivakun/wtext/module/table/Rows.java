package com.github.hivakun.wtext.module.table;

import com.github.hivakun.wtext.arq.module.Text;
import com.github.hivakun.wtext.arq.parameter.TableCellParameter;
import com.github.hivakun.wtext.arq.parameter.TableRowParameter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author rivaldo
 *         Created on 11/10/2016.
 */
public class Rows {

    /**
     * Create a new cells row.
     * Represented by a list of cells.
     *
     * @param text the text of each cell
     * @return a list of cells with their corresponding text
     */
    public static Row newCellRow(String... text) {
        return stringToCell(null, "", text);
    }

    /**
     * Create a new cells row with the desired column parameter.
     * Represented by a list of cells.
     *
     * @param parameter the column parameter for every cell
     * @param text      the text of each cell
     * @return a list of cells with their corresponding text
     */
    public static Row newCustomCellRow(TableRowParameter parameter, @NotNull String paramValue, String... text) {
        return stringToCell(parameter, paramValue, text);
    }

    /**
     * Create a new cells row.
     * Represented by a list of cells.
     *
     * @param text the text of each cell
     * @return a list of cells with their corresponding text
     */
    public static Row newCellRow(Text... text) {
        return textToCell(null, "", text);
    }

    /**
     * Create a new cells row with the desired column parameter.
     * Represented by a list of cells.
     *
     * @param parameter the column parameter for every cell
     * @param text      the text of each cell
     * @return a list of cells with their corresponding text
     */
    public static Row newCustomCellRow(TableRowParameter parameter, @NotNull String paramValue, Text... text) {
        return textToCell(parameter, paramValue, text);
    }

    /**
     * Transform a string list into a cell list.
     *
     * @param rows a list with the cell text
     * @return a list of cells with their corresponding text
     */
    private static Row stringToCell(TableRowParameter parameter, @NotNull String paramValue, String... rows) {

        List<Cell> cells = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(rows)) {
            for (String item : rows) {
                cells.add(new Cell(item));
            }
        }

        Row newRow = new Row(cells);

        if (parameter != null) {
            newRow.setParameter(parameter,paramValue);
        }

        return newRow;
    }

    /**
     * Transform a text list into a cell list.
     *
     * @param rows a list with the cell text
     * @return a list of cells with their corresponding text
     */
    private static Row textToCell(TableRowParameter parameter, @NotNull String paramValue, Text... rows) {

        List<Cell> cells = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(rows)) {
            for (Text item : rows) {
                cells.add(new Cell(item.toString()));
            }
        }

        Row newRow = new Row(cells);

        if (parameter != null) {
            newRow.setParameter(parameter,paramValue);
        }

        return newRow;
    }

    public static class Builder {

        private List<Cell> cells = Lists.newArrayList();
        private List<Cell> cellCache = Collections.EMPTY_LIST;

        private final Map<TableRowParameter, String> parameters = Maps.newHashMap();

        public Builder(@NotNull String... cellText) {
            prepareCache(cellText);
        }

        public Builder(@NotNull Text... cellText) {
            prepareCache(cellText);
        }

        public Builder(@NotNull Cell... cell) {
            prepareCache(cell);
        }

        public Builder appendCell(String... cellText) {

            if (ArrayUtils.isNotEmpty(cellText)) {
                prepareCache(cellText);
            }

            return this;
        }

        public Builder appendCell(Text... cellText) {

            if (ArrayUtils.isNotEmpty(cellText)) {
                prepareCache(cellText);
            }

            return this;
        }

        public Builder appendCell(Cell... cellText) {

            if (ArrayUtils.isNotEmpty(cellText)) {
                prepareCache(cellText);
            }

            return this;
        }

        public Builder withCellParameter(TableCellParameter cellParameter, String paramValue) {
            if (CollectionUtils.isNotEmpty(cellCache)) {
                cellCache.forEach((cell) -> cell.setParameter(cellParameter, paramValue));
            }
            return this;
        }


        public Builder withBackgroundColor(String value) {
            this.parameters.put(TableRowParameter.BACKGROUND_COLOR, value);
            return this;
        }

        public Builder with(TableRowParameter parameter, String value) {
            this.parameters.put(parameter, value);
            return this;
        }

        public Row build() {
            cells.addAll(cellCache);
            return new Row(parameters, cells);
        }

        private void prepareCache(@NotNull String[] cellText) {
            cells.addAll(cellCache);
            cellCache = Lists.newArrayList();

            for (String text : cellText) {
                cellCache.add(new Cell(text));
            }
        }

        private void prepareCache(@NotNull Text[] cellText) {
            cells.addAll(cellCache);
            cellCache = Lists.newArrayList();

            for (Text text : cellText) {
                cellCache.add(new Cell(text.toString()));
            }
        }

        private void prepareCache(@NotNull Cell[] cellText) {
            cells.addAll(cellCache);
            cellCache = Lists.newArrayList(cellText);
        }
    }
}

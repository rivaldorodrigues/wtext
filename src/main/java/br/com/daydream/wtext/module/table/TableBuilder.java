package br.com.daydream.wtext.module.table;

import br.com.daydream.wtext.markup.table.TableParameters;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author rivaldo
 *         Created on 25/04/2016.
 */
public class TableBuilder {

    List<String> header;
    List<List> lines = Lists.newArrayList();
    Map<TableParameters, Object> parameters = Maps.newHashMap();

    public TableBuilder() {
        this.header = Collections.EMPTY_LIST;
        addDefaultParameters();
    }

    public TableBuilder(List<String> header) {
        this.header = header;
        addDefaultParameters();
    }

    public TableBuilder withBorder(int val) {
        parameters.put(TableParameters.BORDER, val);
        return this;
    }

    public TableBuilder withCellpadding(int val) {
        parameters.put(TableParameters.CELL_PADDING, val);
        return this;
    }

    public TableBuilder withCellspacing(int val) {
        parameters.put(TableParameters.CELL_SPACING, val);
        return this;
    }

    public TableBuilder withHeader(List<String> val) {
        this.header = val;
        return this;
    }

    public TableBuilder addNewLine(List line) {
        this.lines.add(line);
        return this;
    }

    public boolean isEmptyTable() {
        return header.isEmpty() && lines.isEmpty();
    }

    public Table build() {
        return new Table(this);
    }

    private void addDefaultParameters() {
        withBorder(1);
        withCellpadding(2);
        withCellspacing(0);
    }
}

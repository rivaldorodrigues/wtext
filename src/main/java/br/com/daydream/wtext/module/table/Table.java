package br.com.daydream.wtext.module.table;

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


import br.com.daydream.wtext.markup.table.TableMarkup;
import br.com.daydream.wtext.markup.table.TableParameter;
import br.com.daydream.wtext.module.Element;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author rivaldo
 * Created on 25/04/2016.
 */
public class Table extends Element {

    Table(TableBuilder builder) {
        super("");
        element = format(builder);
    }

    private String format(TableBuilder builder) {

        String wikiTable = "";

        if (!builder.isEmptyTable()) {

            StringBuilder sBuilder = new StringBuilder(initTableAndStyle(builder.parameters));

            sBuilder.append(addCaption(builder.caption));
            sBuilder.append(addHeader(builder.header));
            sBuilder.append(addRows(builder.rows));

            wikiTable = TableMarkup.TABLE_END.apply(sBuilder.toString());
        }

        return wikiTable;
    }

    private String initTableAndStyle(Map<TableParameter, Object> param) {

        StringBuilder sBuilder = new StringBuilder();

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(" ").append(k.apply(v)));
        }

        return TableMarkup.TABLE_START.apply(sBuilder.toString());
    }

    private String addCaption(Cell caption) {
        return caption != null ? caption.toString() : "";
    }

    private String addHeader(List<Cell> header) {
        return iterateCellList(header);
    }

    private String addRows(List<List<Cell>> rows) {

        String result = "";

        if (CollectionUtils.isNotEmpty(rows)) {
            StringBuilder sBuilder = new StringBuilder();
            rows.forEach(row -> sBuilder.append(addRow(row)));
            result = sBuilder.toString();
        }

        return result;
    }

    private String addRow(List<Cell> row) {

        String result = iterateCellList(row);

        if (StringUtils.isNotEmpty(result)) {
            result = TableMarkup.ROW.apply(result);
        }

        return result;
    }
    
    private String iterateCellList(List<Cell> data) {
        
        StringBuilder sBuilder = new StringBuilder();

        if (CollectionUtils.isNotEmpty(data)) {
            data.forEach( item -> sBuilder.append(item) );
        }
        
        return sBuilder.toString();
    }
}

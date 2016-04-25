package br.com.daydream.wtext.module.table;

import br.com.daydream.wtext.markup.table.CellType;
import br.com.daydream.wtext.markup.table.TableMarkup;
import br.com.daydream.wtext.markup.table.TableParameters;
import br.com.daydream.wtext.module.Element;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;

/**
 * @author rivaldo
 * Created on 25/04/2016.
 */
public class Table extends Element {

    public Table(String element) {
        super(element);
    }

    private StringBuilder initTableAndStyle(Map<TableParameters, Object> param) {

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(TableMarkup.TABLE_START);

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(" ").append(k).append(v).append("\""));
        }

        sBuilder.append("\n");
        return sBuilder;
    }

    private void addLines(StringBuilder sBuilder, List<List> lines) {

        if (CollectionUtils.isNotEmpty(lines)) {
            lines.forEach(line -> addLine(sBuilder, line));
        }
    }

    private void addLine(StringBuilder sBuilder, List line) {

        if (CollectionUtils.isNotEmpty(line)) {
            sBuilder.append(TableMarkup.COLUMN_START).append("\n");
            line.forEach( item -> sBuilder.append(TableMarkup.COLUMN_ITEM_DELIMITER).append(item) );
            sBuilder.append("\n").append(TableMarkup.COLUMN_END).append("\n");
        }
    }

    private String format(TableBuilder builder) {

        String wikiTable = "";

        if (!builder.isEmptyTable()) {

            StringBuilder sBuilder = initTableAndStyle(builder.parameters);

            addHeader(sBuilder, builder.header);
            addLines(sBuilder, builder.lines);

            sBuilder.append(TableMarkup.TABLE_END);

            wikiTable = sBuilder.toString();
        }

        return wikiTable;
    }

    private void addHeader(StringBuilder sBuilder, List<String> header) {
        if (CollectionUtils.isNotEmpty(header)) {
            header.forEach(item -> sBuilder.append(CellType.HEADER.apply(item)));
        }
    }
}

package br.com.daydream.wtext.formatter;

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


import br.com.daydream.wtext.arq.formatter.SourceFormatter;
import br.com.daydream.wtext.arq.parameter.SourceParameter;
import br.com.daydream.wtext.markup.source.SourceMarkup;
import org.apache.commons.collections4.MapUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiSourceFormatter implements SourceFormatter {

    private static final String HIGHLIGHT_SEPARATOR = ",";

    @Override
    public String paramLang(String text) {
        return SourceMarkup.LANG.apply(text);
    }

    @Override
    public String paramTitle(String text) {
        return SourceMarkup.TITLE.apply(text);
    }

    @Override
    public String paramHighlight(String text) {
        return SourceMarkup.HIGHLIGHT.apply(text);
    }

    @Override
    public String getHighlightAsText(@NotNull int... val) {

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(val[0]);

        for (int i = 1; i < val.length; ++i) {
            sBuilder.append(HIGHLIGHT_SEPARATOR).append(val[i]);
        }

        return sBuilder.toString();
    }

    @Override
    public String formatSourcer(String sourcer, Map<SourceParameter, String> param) {
        StringBuilder sBuilder = new StringBuilder(initSourceAndStyle(param));
        sBuilder.append(sourcer);

        return SourceMarkup.SOURCE_END.apply(sBuilder.toString());
    }

    private String initSourceAndStyle(Map<SourceParameter, String> param) {

        StringBuilder sBuilder = new StringBuilder();

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(" ").append(k.apply(v)));
        }

        return SourceMarkup.SOURCE_START.apply(sBuilder.toString());
    }
}

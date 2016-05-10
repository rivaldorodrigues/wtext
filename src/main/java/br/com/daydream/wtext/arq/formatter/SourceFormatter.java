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


import br.com.daydream.wtext.arq.parameter.SourceParameter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Interface to all classes that implement the source formatting strategy.
 * @see br.com.daydream.wtext.module.source.Source
 *
 * @author hivakun
 * Created on 01/05/16
 */
public interface SourceFormatter {

    /**
     * Apply the desired value to the lang source parameter.
     *
     * @param val the desired value
     * @return the markup text of the source lang parameter with the desired value
     */
    String paramLang(@NotNull Object val);

    /**
     * Apply the desired value to the title source parameter.
     *
     * @param val the desired value
     * @return the markup text of the source title parameter with the desired value
     */
    String paramTitle(@NotNull Object val);

    /**
     * Apply the desired value to the highlight source parameter.
     *
     * @param val the desired value
     * @return the markup text of the source highlight parameter with the desired value
     */
    String paramHighlight(@NotNull Object val);

    /**
     * Get all the highlight line indexes and transform it into a single string.
     *
     * @param val the indexes of the lines to be highlighted
     * @return a single string that represent all the indexes
     */
    String getHighlightAsText(int... val);

    /**
     * Format the source and apply the specified parameters.
     *
     * @param sourcer the source to be formated
     * @param param an map with all the desired parameters
     * @return a string formatted with the source markup
     */
    String formatSourcer(String sourcer, Map<SourceParameter, Object> param);
}

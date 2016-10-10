package com.github.hivakun.wtext.arq.formatter;

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

import com.github.hivakun.wtext.arq.module.Text;

/**
 * Interface to all classes that implement the text formatting strategy.
 * @see Text
 *
 * @author hivakun
 * Created on 01/05/16
 */
public interface TextFormatter {

    /**
     * Apply the bold style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with bold style markup
     */
    String bold(String text);

    /**
     * Apply the italic style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with italic style markup
     */
    String italic(String text);

    /**
     * Apply the italic and bold style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with italic and bold style markup
     */
    String italicBold(String text);

    /**
     * Apply the small caps style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with small caps style markup
     */
    String smallCaps(String text);

    /**
     * Apply the code style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with code style markup
     */
    String code(String text);

    /**
     * Apply the small style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with small style markup
     */
    String small(String text);

    /**
     * Apply the big style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with big style markup
     */
    String big(String text);

    /**
     * Apply the block quote style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with block quote style markup
     */
    String blockQuote(String text);

    /**
     * Apply the center style markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with center style markup
     */
    String center(String text);
}

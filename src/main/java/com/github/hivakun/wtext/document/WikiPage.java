package com.github.hivakun.wtext.document;

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


import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;

/**
 * Represents a wiki page document that can be written into a file.
 *
 * @author hivakun
 * Created on 11/05/16
 */
public class WikiPage extends Document {

    /**
     * Creates a new wiki page.
     *
     * @param output the output document file
     */
    WikiPage(@NotNull OutputStream output) {
        super(output);
    }
}

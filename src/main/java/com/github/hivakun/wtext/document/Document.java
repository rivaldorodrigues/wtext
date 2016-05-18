package com.github.hivakun.wtext.document;

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


import com.github.hivakun.wtext.arq.module.Element;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Represents a generic document that can be written into a file.
 *
 * @author hivakun
 * Created on 11/05/16
 */
public abstract class Document implements AutoCloseable {

    private boolean open;
    private BufferedOutputStream os;

    private static byte[] NEW_LINE = "\n".getBytes();

    /**
     * Creates a new document.
     *
     * @param output the output document file
     */
    protected Document(@NotNull OutputStream output) {
        this.open = true;
        this.os = new BufferedOutputStream(output);
    }

    /**
     * Append the element to the document.
     *
     * @param element the element to be appended
     * @return the document itself
     * @throws DocumentIOException a runtime error that encapsulate an IOException
     */
    public Document addElement(@NotNull Element element) throws DocumentIOException {
        try {
            os.write(element.toString().getBytes());
            os.write(NEW_LINE);
            os.flush();
        } catch (IOException e) {
            throw new DocumentIOException("Could not add the element.", e);
        }

        return this;
    }

    /**
     * Append a new line to the document.
     *
     * @return the document itself
     * @throws DocumentIOException a runtime error that encapsulate an IOException
     */
    public Document newLine() {
        try {
            os.write(NEW_LINE);
            os.flush();
        } catch (IOException e) {
            throw new DocumentIOException("Could not add a new line.", e);
        }

        return this;
    }

    /**
     * Close the document.
     *
     * @throws IOException error while trying to close the output stream
     */
    public void close() throws IOException {
        if (isOpen()) {
            os.flush();
            os.close();
        }
    }

    /**
     * Checks if the document is open.
     *
     * @return true if the document is open, false otherwise
     */
    public boolean isOpen() {
        return os != null && open;
    }

    /**
     * Checks if the document is closed.
     *
     * @return true if the document is closed, false otherwise
     */
    public boolean isClose() {
        return os == null || !open;
    }
}

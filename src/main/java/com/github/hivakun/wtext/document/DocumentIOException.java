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


/**
 * A runtime document IOException
 *
 * @author hivakun
 * Created on 11/05/16
 */
public class DocumentIOException extends RuntimeException {

    /**
     * Create a new document exception.
     */
    public DocumentIOException() {
    }

    /**
     * Create a new document exception.
     *
     * @param message the error message
     */
    public DocumentIOException(String message) {
        super(message);
    }

    /**
     * Create a new document exception.
     *
     * @param message the error message
     * @param cause the error cause
     */
    public DocumentIOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create a new document exception.
     *
     * @param cause the error cause
     */
    public DocumentIOException(Throwable cause) {
        super(cause);
    }
}

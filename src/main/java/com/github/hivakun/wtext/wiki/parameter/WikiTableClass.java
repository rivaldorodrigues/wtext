package com.github.hivakun.wtext.wiki.parameter;

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


import com.github.hivakun.wtext.arq.parameter.TableClass;
import org.jetbrains.annotations.NotNull;

/**
 * Enum that hold a set of commons mediawiki css table classes.
 * @see com.github.hivakun.wtext.arq.parameter.TableClass
 *
 * @author hivakun
 * Created on 10/10/16
 */
public enum WikiTableClass implements TableClass {

    WIKITABLE("wikitable"),

    SORTABLE("sortable"),

    COLLAPSIBLE("collapsible mw-collapsible"),

    COLLAPSED("collapsible mw-collapsible mw-collapsed");

    private final String clazz;

    /**
     * Creates the constants of mediawiki table class.
     */
    WikiTableClass(@NotNull String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getTableClass() {
        return clazz;
    }
}

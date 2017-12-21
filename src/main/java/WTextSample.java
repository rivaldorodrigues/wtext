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

import com.github.hivakun.wtext.arq.parameter.TableCellParameter;
import com.github.hivakun.wtext.arq.parameter.TableRowParameter;
import com.github.hivakun.wtext.arq.parameter.TextFormat;
import com.github.hivakun.wtext.document.Document;
import com.github.hivakun.wtext.document.Documents;
import com.github.hivakun.wtext.module.link.Links;
import com.github.hivakun.wtext.module.list.ListBuilder;
import com.github.hivakun.wtext.module.list.ListItem;
import com.github.hivakun.wtext.module.paragraph.Paragraph;
import com.github.hivakun.wtext.module.paragraph.ParagraphBuilder;
import com.github.hivakun.wtext.module.section.Section;
import com.github.hivakun.wtext.module.section.Sections;
import com.github.hivakun.wtext.module.source.Source;
import com.github.hivakun.wtext.module.source.SourceBuilder;
import com.github.hivakun.wtext.module.table.Row;
import com.github.hivakun.wtext.module.table.Rows;
import com.github.hivakun.wtext.module.table.Table;
import com.github.hivakun.wtext.module.table.TableBuilder;
import com.github.hivakun.wtext.wiki.parameter.WikiTableClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WTextSample {

    public static void main(String[] args) {

        try (Document page = Documents.newWikiPage(new FileOutputStream("MyPage.txt"))) {

            // Page Title
            Section pageTitle = Sections.newSection("My Sample Page");

            page.addElement(pageTitle).newLine();

            // Table Element
            Section sectionTable = Sections.newSubsection("Table Sample");
            page.addElement(sectionTable).newLine();
            page.addElement(createSampleTable());
            page.newLine();
//
//            // Code Element
//            Section sectionCode = Sections.newSubsection("Code Sample");
//
//            page.addElement(sectionCode).newLine();
//            page.addElement(createCodeSample());
//            page.newLine();
//
//            // List Element
//            Section sectionList = Sections.newSubsection("List Sample");
//
//            page.addElement(sectionList).newLine();
//            page.addElement(createListSample());
//            page.newLine();
//
//            // Paragraph element
//            Section sectionParagraph = Sections.newSubsection("Paragraph Sample");
//            page.addElement(sectionParagraph).newLine();
//            page.addElement(createParagraphSample());

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error: File could not be closed.");
        }
    }

    public static Paragraph createParagraphSample() {
        ParagraphBuilder builder = new ParagraphBuilder();

        builder.append("Click ");
        builder.append(Links.newExternalLink("https://github.com/hivakun/wtext/wiki", "here"));
        builder.append(" for ");
        builder.append("more information").withFormat(TextFormat.BOLD);
        builder.append(" or visite the ");
        builder.append("WText").withFormat(TextFormat.ITALIC_BOLD);
        builder.append(" web site at: ");
        builder.append(Links.newExternalLink("https://github.com/hivakun/wtext")).withFormat(TextFormat.CODE);

        return builder.buildParagraph();
    }

    public static Table createSampleTable() {

        Row header = Rows.newCellRow("Date", "Version", "Revision");
        Row fistRow = Rows.newCellRow("15/03/2016", "1.5.3", "263");
        //Row secondRow = Rows.newCellRow("18/12/2015", "1.5.2", "250");

        Rows.Builder builder1 = new Rows.Builder("TESTE");
        builder1.withCellParameter(TableCellParameter.COLSPAN, "2");
        builder1.with(TableRowParameter.STYLE, "font-size:86%");
        builder1.withBackgroundColor("#FF0000");

        TableBuilder builder = new TableBuilder(header);
        builder.withCaption("Table Sample");
        builder.addNewRow(fistRow);
        builder.addNewRow(builder1.build());

        builder.addTableClass(WikiTableClass.WIKITABLE, WikiTableClass.SORTABLE);

        return builder.buildTable();
    }

    public static com.github.hivakun.wtext.module.list.List createListSample() {
        ListBuilder builder = new ListBuilder();

        new ListItem(1, "Item 1");
        new ListItem(2, "Item 1.1");
        new ListItem(1, "Item 2");
        new ListItem(2, "Item 1.1");

        builder.addItem(1, "Item 1");
        builder.addItem(1, "Item 2");
        builder.addItem(2, "Sub-item 3");
        builder.addItem(3, "Sub-item 4");

        return builder.buildUnorderedList();
    }

    public static Source createCodeSample() {
        SourceBuilder builder = new SourceBuilder();
        builder.withTitle("Awesome code").withLang("java").withHighLight(3, 7, 8);

        builder.append("public class Elvis {\n");
        builder.append("\n");
        builder.append("    private static final Elvis INSTANCE = new Elvis();\n");
        builder.append("\n");
        builder.append("    private Elvis() { ... };\n");
        builder.append("\n");
        builder.append("    public static Elvis getInstance()\n");
        builder.append("    { return INSTANCE; }\n");
        builder.append("\n");
        builder.append("    public void leaveTheBuilding() { ... }\n");
        builder.append("}");

        return builder.buildSource();
    }
}

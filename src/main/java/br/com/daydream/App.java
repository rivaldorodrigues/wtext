package br.com.daydream;

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


import br.com.daydream.wtext.WikiPage;
import br.com.daydream.wtext.module.link.Links;
import br.com.daydream.wtext.module.paragraph.Paragraph;
import br.com.daydream.wtext.module.paragraph.ParagraphBuilder;
import br.com.daydream.wtext.module.section.Sections;
import br.com.daydream.wtext.module.source.Source;
import br.com.daydream.wtext.module.source.SourceBuilder;
import br.com.daydream.wtext.module.table.Cell;
import br.com.daydream.wtext.module.table.Cells;
import br.com.daydream.wtext.module.table.Table;
import br.com.daydream.wtext.module.table.TableBuilder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(WikiPage page = new WikiPage(new FileOutputStream("teste.txt"))) {

            Paragraph titulo = Sections.newSection("Inicio da página");
            Paragraph tituloTabela = Sections.newSubsection("Aqui bem uma tabela");

            page.addElement(titulo);
            page.newLine();

            page.addElement(tituloTabela);
            page.newLine();

            page.addElement(criarTabela());
            page.newLine();

            Paragraph tituloCodigo = Sections.newSubsection("Aqui vem um código");

            page.addElement(tituloCodigo);
            page.newLine();

            page.addElement(criarCodigo());
            page.newLine();

            ParagraphBuilder builder = new ParagraphBuilder();
            builder.append(Links.newFileLink("Manual_SGM-Mobile-v1.2_WM.docx"));
            builder.append(" ");
            builder.append(Links.newFileLink("Manual_SGM-Mobile-v1.2_WM.pdf","PDF"));

            page.addElement(builder.buildParagraph());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }

    public static Table criarTabela() {
        Cell legenda = Cells.newTableCaption("Legenda");
        List<Cell> cabecalho = Cells.newTableHeader("Data", "Versão", "Revisão", "Homologação", "Produção");
        List<Cell> linha = Cells.newTableRow("18/12/2015", "1.5.2", "--", "--", "[[Arquivo:SGM v1.5.2.zip]]");

        TableBuilder builder = new TableBuilder(cabecalho);
        builder.withCaption(legenda);
        builder.addNewRow(linha);
        builder.addNewRow(linha);

        return builder.build();
    }

    public static Source criarCodigo() {

        SourceBuilder builder = new SourceBuilder();
        builder.withTitle("Awesome code").withLang("java").withHighLight(3,7,8);


        String s = "public class Elvis {\n" +
                "\n" +
                "    private static final Elvis INSTANCE = new Elvis();\n" +
                "\n" +
                "    private Elvis() { ... };\n" +
                "\n" +
                "    public static Elvis getInstance()\n" +
                "    { return INSTANCE; }\n" +
                "\n" +
                "    public void leaveTheBuilding() { ... }\n" +
                "}";

        builder.append(s);

        return builder.build();
    }
}

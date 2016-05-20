# WText

WText is a simple java library to create wiki pages formatted with mediawiki markup.

This project aims to make the task of creating and writing wiki documents in Java much more easier.

To do this, the library encapsulates a set of elements commonly used in wiki pages (such as paragraphs, tables, source code, links and lists) and represents these elements into classes, allowing easy handling of these elements by Java developers without having to work with the wiki markup language.

##How to use

The artifact is in the [Maven Central](http://search.maven.org/) repository so all you need to do is add it as a dependency in your project.

###### Maven
----------

``` xml
<dependency>
	<groupId>com.github.hivakun</groupId>
	<artifactId>wtext</artifactId>
	<version>1.0.0</version>
</dependency>
```

###### Gradle
----------

``` xml
compile 'com.github.hivakun:wtext:1.0.0'
```

After this, create an instance of ''Document''. The ''Documents'' class is a factory that allows easy creation of documents with the dialect that will be used to write the document and the output where the information will be written.

```java
Documents.newWikiPage(DocumentFormat.MEDIAWIKI, new FileOutputStream("MyPage.txt"));
```

For now, only the Mediawiki format is supported. Thus, it is not necessary informs the document dialect. The Mediawiki format will be used by default.

```java
Documents.newWikiPage(new FileOutputStream("MyPage.txt"));
```

Now that you have an instance of '' Document 'it is possible to add elements such as paragraphs, tables, source code, links and lists. See example below. 

For details of each element, visit the [project wiki](https://github.com/hivakun/wtext/wiki).

### Complete Sample

```java
import com.github.hivakun.wtext.arq.parameter.TextFormat;
import com.github.hivakun.wtext.document.Document;
import com.github.hivakun.wtext.document.Documents;
import com.github.hivakun.wtext.module.link.Links;
import com.github.hivakun.wtext.module.list.ListBuilder;
import com.github.hivakun.wtext.module.paragraph.Paragraph;
import com.github.hivakun.wtext.module.paragraph.ParagraphBuilder;
import com.github.hivakun.wtext.module.section.Section;
import com.github.hivakun.wtext.module.section.Sections;
import com.github.hivakun.wtext.module.source.Source;
import com.github.hivakun.wtext.module.source.SourceBuilder;
import com.github.hivakun.wtext.module.table.Cell;
import com.github.hivakun.wtext.module.table.Cells;
import com.github.hivakun.wtext.module.table.Table;
import com.github.hivakun.wtext.module.table.TableBuilder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

            // Code Element
            Section sectionCode = Sections.newSubsection("Code Sample");

            page.addElement(sectionCode).newLine();
            page.addElement(createCodeSample());
            page.newLine();

            // List Element
            Section sectionList = Sections.newSubsection("List Sample");

            page.addElement(sectionList).newLine();
            page.addElement(createListSample());
            page.newLine();

            // Paragraph element
            Section sectionParagraph = Sections.newSubsection("Paragraph Sample");
            page.addElement(sectionParagraph).newLine();
            page.addElement(createParagraphSample());

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

        List<Cell> header = Cells.newCellRow("Date", "Version", "Revision");
        List<Cell> fistRow = Cells.newCellRow("15/03/2016", "1.5.3", "263");
        List<Cell> secondRow = Cells.newCellRow("18/12/2015", "1.5.2", "250");

        TableBuilder builder = new TableBuilder(header);
        builder.withCaption("Table Sample");
        builder.addNewRow(fistRow);
        builder.addNewRow(secondRow);

        return builder.buildTable();
    }

    public static com.github.hivakun.wtext.module.list.List createListSample() {
        ListBuilder builder = new ListBuilder();
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
```
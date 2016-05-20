# WText

WText is a simple java library to create wiki pages formatted with *Mediawiki* markup.

This project aims to make the task of creating and writing wiki documents in Java much more easier.

To do this, this library encapsulates a set of elements, commonly used in wiki pages (such as paragraphs, tables, source code, links and lists) and represents these elements into classes, allowing easy handling of these elements by Java developers without having to work with the wiki markup language.

## How to use

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

### Creating a document

Now that everything is set, you need an instance of `Document`. The `Documents` class is a factory that allows easy creation of documents with the dialect that will be used to write the document and the output where the information will be written.

```java
Documents.newWikiPage(DocumentFormat.MEDIAWIKI, new FileOutputStream("MyPage.txt"));
```

For now, only the *Mediawiki* format is supported. Thus, it is not necessary informs the document dialect. Using the code below, the *Mediawiki* format will be used by default.

```java
Documents.newWikiPage(new FileOutputStream("MyPage.txt"));
```

### Writing the document

Now that you have an instance of `Document` it is possible to add elements such as paragraphs, tables, source code, links and lists.

For details of each element, visit the [project wiki](https://github.com/hivakun/wtext/wiki) or just check out our [complete example](https://github.com/hivakun/wtext/wiki/Complete-Sample) which use the most common elements.

The example below shows how to create your fist wiki page with a simple paragraph.

```java
import com.github.hivakun.wtext.arq.parameter.TextFormat;
import com.github.hivakun.wtext.document.Document;
import com.github.hivakun.wtext.document.Documents;
import com.github.hivakun.wtext.module.paragraph.Paragraph;
import com.github.hivakun.wtext.module.paragraph.ParagraphBuilder;
import com.github.hivakun.wtext.module.section.Section;
import com.github.hivakun.wtext.module.section.Sections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WTextSample {

    public static void main(String[] args) {

        try (Document page = Documents.newWikiPage(new FileOutputStream("MyPage.txt"))) {

            // Page Title
            Section pageTitle = Sections.newSection("My Sample Page");
            page.addElement(pageTitle).newLine();

            // Paragraph element
            ParagraphBuilder builder = new ParagraphBuilder();

            builder.append("This is my first wiki page.\n");
            builder.append("That is awesome!").withFormat(TextFormat.BOLD);

            Paragraph paragraph = builder.buildParagraph();
            page.addElement(paragraph);

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error: File could not be closed.");
        }
    }
}
```
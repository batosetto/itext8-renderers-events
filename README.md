# itext8-renderers-events

A project exploring the advanced features of iText 8, focusing on custom renderers and event handlers for PDF generation. This repository contains examples that demonstrate how to use iText to customize PDF layouts, such as applying block renderers, creating custom cell borders, and handling document-level events like watermarks and page backgrounds.

## Features

- **Custom Block Renderers:** Learn how to apply block renderers for complex PDF layouts.
- **Table Styling:** Add custom cell borders, background colors, and rounded corners to PDF tables.
- **Event Handling:** Automatically add headers, footers, watermarks, and background colors across pages.
- **PDF Manipulation:** Explore advanced techniques to manipulate the layout and structure of PDF files.

## Examples

### 1. Applying a Block Renderer
This example shows how to process a CSV file and use custom renderers to style a table with colored cells and rounded borders.

### 2. Custom Cell Borders and Background Colors
Add unique borders to cells, and dynamically change the background color of certain columns based on content.

### 3. Handling PDF Events
Learn how to handle document-level events, such as adding a watermark and applying different background colors to odd and even pages.

## Installation

To run this project, ensure you have the following dependencies in your \`pom.xml\`:

\`\`\`xml
<dependencies>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>itext-core</artifactId>
        <version>8.0.5</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>layout</artifactId>
        <version>8.0.5</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.36</version>
    </dependency>
</dependencies>
\`\`\`

## Running the Examples

1. Clone the repository:
   \`\`\`bash
   git clone https://github.com/batosetto/itext8-renderers-events.git
   \`\`\`

2. Build the project:
   \`\`\`bash
   mvn clean install
   \`\`\`

3. Run the main examples in your IDE or terminal.

## License

This project is licensed under the AGPL license. See the [LICENSE](LICENSE) file for more details.
" > README.md

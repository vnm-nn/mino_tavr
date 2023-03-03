package com.mino_tavr.service.docTemplateService;

import com.cubateka.documentextractor.cards.DocPath;
import com.cubateka.documentextractor.cards.ManufacturingDoc;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class TicketCard extends Card {
    private void writeTitleField(List<XWPFTable> tables, ManufacturingDoc documentData) {
        final int fs = 16;
        var cardNumberCell = tables.get(0).getRow(0).getCell(1);
        writeField(cardNumberCell, documentData.getCardNumber(), fs);
        cardNumberCell = tables.get(4).getRow(0).getCell(1);
        writeField(cardNumberCell, documentData.getCardNumber(), fs);
    }
    private void writeDateField(List<XWPFTable> tables, ManufacturingDoc documentData) {
        final var dateBegin = tables.get(1).getRow(2).getCell(0);
        writeField(dateBegin, documentData.getInteractionBegin().date()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), 14);
    }
    private void writeInteractionField(List<XWPFTable> tables, ManufacturingDoc documentData) {
        final int fs = 12;
        int rowPosition = 2;
        for(final var interaction : List.of(documentData.getInteractionBegin().customer(),
                documentData.getInteractionBegin().contractor())) {
            final var nameCell = tables.get(6).getRow(rowPosition).getCell(0);
            writeField(nameCell, interaction.name(), fs);
            final var managementCell = tables.get(6).getRow(rowPosition).getCell(1);
            writeField(managementCell, interaction.management(), fs);
            final var departmentCell = tables.get(6).getRow(rowPosition).getCell(2);
            writeField(departmentCell, interaction.department(), fs);
            rowPosition = 5;
        }
    }
    public TicketCard(ManufacturingDoc documentData, DocPath documentPath) throws IOException {
        super(documentData, documentPath);
    }
    @Override
    public ByteArrayInputStream crateDocument() throws IOException {
        writeTitleField(this.getTables(), this.getDocumentData());
        writeDateField(this.getTables(), this.getDocumentData());
        writeInteractionField(this.getTables(), this.getDocumentData());

        final ByteArrayOutputStream b = new ByteArrayOutputStream();
        this.getDoc().write(b);
        return new ByteArrayInputStream(b.toByteArray());
    }
}

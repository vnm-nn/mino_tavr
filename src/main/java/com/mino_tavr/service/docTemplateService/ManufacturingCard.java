package com.mino_tavr.service.docTemplateService;

import com.mino_tavr.dto.SingleCardNumberResponseDto;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;

public class ManufacturingCard extends Card {
    private void writeTitleField(List<XWPFTable> tables,
                                 SingleCardNumberResponseDto docData) throws IOException, InvalidFormatException {
        final int fs = 16;
        final var cardNumberCell = tables.get(0).getRow(1).getCell(0);
        writeField(cardNumberCell, docData.getNumber(), fs);

        final var deviceTypeCell = tables.get(0).getRow(3).getCell(0);
        writeField(deviceTypeCell, this.getDeviceType()[docData.getDevice_type()], fs);

        final var image = tables.get(0).getRow(0).getCell(1);
        image.addParagraph().createRun().addPicture(
                new ByteArrayInputStream(docData.getImage()),
                Document.PICTURE_TYPE_JPEG,
                Arrays.toString(docData.getImage()),
                Units.toEMU(200),
                Units.toEMU(150));
    }
    private void writeInteractionField(List<XWPFTable> tables, SingleCardNumberResponseDto docData) {
        final int fs = 12;
        int rowPosition = 3;

        docData.getDescription();


        for(final var interaction : List.of(docData.getInteractionBegin().contractor(),
                documentData.getInteractionBegin().customer())) {
            final var nameCell = tables.get(1).getRow(rowPosition).getCell(1 );
            writeField(nameCell, interaction.name(), fs);
            final var managementCell = tables.get(1).getRow(rowPosition).getCell(2 );
            writeField(managementCell, interaction.management(), fs);
            final var departmentCell = tables.get(1).getRow(rowPosition).getCell(3);
            writeField(departmentCell, interaction.department(), fs);
            rowPosition++;
        }

        rowPosition = 3;
        for(final var interaction : List.of(documentData.getInteractionEnd().customer(),
                documentData.getInteractionEnd().contractor())) {
            final var nameCell = tables.get(1).getRow(rowPosition).getCell(4);
            writeField(nameCell, interaction.name(), fs);
            final var managementCell = tables.get(1).getRow(rowPosition).getCell(5);
            writeField(managementCell, interaction.management(), fs);
            final var departmentCell = tables.get(1).getRow(rowPosition).getCell(6);
            writeField(departmentCell, interaction.department(), fs);
            rowPosition++;
        }

        final var dateBegin = tables.get(1).getRow(5).getCell(1);
        writeField(dateBegin, documentData.getInteractionBegin().date()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), fs);
        final var dateEnd = tables.get(1).getRow(5).getCell(2);
        writeField(dateEnd, documentData.getInteractionEnd().date()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), fs);
    }
    private void writeWorkReasonField(List<XWPFTable> tables, ManufacturingDoc documentData) {
        final int fs = 14;
        final var reasonCell = tables.get(2).getRow(1).getCell(0);
        writeField(reasonCell, documentData.getWorkReason().reason().getReasonName(), fs);
        final var reasonNumberCell =tables.get(2).getRow(1).getCell(1);
        writeField(reasonNumberCell, documentData.getWorkReason().reasonNumber(), fs);
    }
    private void writeDescriptionField(List<XWPFTable> tables, ManufacturingDoc documentData) throws IOException, XmlException {
        final int fs = 12;
        XWPFTableRow rowTemplate = tables.get(3).getRow(1);
        for(final var device : documentData.getDeviceDescription()) {
            CTRow ctrow = CTRow.Factory.parse(rowTemplate.getCtRow().newInputStream());
            XWPFTableRow descriptionRow = new XWPFTableRow(ctrow, tables.get(3));
            final var nameCell = descriptionRow.getCell(0);
            writeField(nameCell, device.getName(), fs);
            final var serialNumberCell = descriptionRow.getCell(1);
            writeField(serialNumberCell, device.getSerialNumber(), fs);
            final var inventoryNumberCell = descriptionRow.getCell(2);
            writeField(inventoryNumberCell, device.getInventoryNumber(), fs);
            final var remarkCell =  descriptionRow.getCell(3);
            writeField(remarkCell, device.getRemark(), fs);
            tables.get(3).addRow(descriptionRow);
        }
    }

    public ManufacturingCard(SingleCardNumberResponseDto docData, DocumentPath documentPath) throws IOException {
        super(docData, documentPath);
    }

    @Override
    public ByteArrayInputStream crateDocument() throws IOException, InvalidFormatException, XmlException {
        writeTitleField(this.getTables(), this.getDocData());
        writeInteractionField(this.getTables(), this.getDocumentData());
        writeWorkReasonField(this.getTables(), this.getDocumentData());
        writeDescriptionField(this.getTables(), this.getDocumentData());

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        this.getDoc().write(b);
        return new ByteArrayInputStream(b.toByteArray());
    }
}
package com.mino_tavr.service.docTemplateService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentPath {
    MANUFACTURING("DocumentTemplates/manufacturing.docx"),
    TICKET("DocumentTemplates/ticket.docx");
    private final String docPath;
}

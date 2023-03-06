package com.mino_tavr.controller;

import com.mino_tavr.dto.AddModelRequestDto;
import com.mino_tavr.dto.SingleModelResponseDto;
import com.mino_tavr.service.docTemplateService.DocumentPath;
import com.mino_tavr.service.docTemplateService.ManufacturingCard;
import com.mino_tavr.service.docTemplateService.TicketCard;
import com.mino_tavr.service.manufactureService.ManufactureService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/manufacture")
@RequiredArgsConstructor
public class ManufactureController {
    private final ManufactureService manufacture;

    @PostMapping("/add")
    public void addModel(@RequestBody AddModelRequestDto modelData) {
        manufacture.addModel(modelData);
    }

    @GetMapping("/{id}")
    public SingleModelResponseDto getSingleModel(@PathVariable Integer id) {
        return manufacture.getModelById(id);
    }

// TODO it is necessary to implement data transfer from the database by DEVICE_TYPE following the example below

  //  @GetMapping("/photo")
   // public List<AllCardNumberResponseDto> getAllCardNumber() {
     //   return cardNumberService.getAllCardNumber();

    //}

    @GetMapping(value = "/doc/{name}/{id}",
            produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<InputStreamResource> getDocTemplate(
            @PathVariable Integer name, @PathVariable Integer id) throws IOException, XmlException, InvalidFormatException {
        var modelData = manufacture.getModelById(id);
        final var card = switch(name) {
            case 1 -> new TicketCard(modelData, DocumentPath.TICKET);
            case 2 -> new ManufacturingCard(modelData, DocumentPath.MANUFACTURING);
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "inline; filename=" + id + ".docx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new InputStreamResource(card.crateDocument()));
    }
}
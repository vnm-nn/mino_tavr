package com.mino_tavr.controller;

import com.mino_tavr.dto.AddCardNumberRequestDto;
import com.mino_tavr.dto.AllCardNumberResponseDto;
import com.mino_tavr.dto.SingleCardNumberResponseDto;
import com.mino_tavr.service.cardNumberService.CardNumberService;
import com.mino_tavr.service.docTemplateService.DocumentPath;
import com.mino_tavr.service.docTemplateService.ManufacturingCard;
import com.mino_tavr.service.docTemplateService.TicketCard;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/card_numbers")
@RequiredArgsConstructor
public class CardNumberController {

    private final CardNumberService cardNumberService;

    @PostMapping()
    public void add(@RequestBody AddCardNumberRequestDto addCardNumberRequestDto) {

        cardNumberService.add(addCardNumberRequestDto);

    }

    @GetMapping
    public List<AllCardNumberResponseDto> getAllCardNumber() {

        return cardNumberService.getAllCardNumber();

    }

    @GetMapping(path = "/{id_card_number}")
    public SingleCardNumberResponseDto getCardNumberById(@PathVariable Integer id_card_number) {

        return cardNumberService.getCardNumberById(id_card_number);
    }

    @GetMapping(value = "/doc/{id_card_number}", produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<InputStreamResource> word(@PathVariable int id_card_number) throws IOException, InvalidFormatException, XmlException {
        SingleCardNumberResponseDto docData = cardNumberService.getCardNumberById(id_card_number);
        final var card = switch (id_card_number) {
            case 1 -> new TicketCard(docData, DocumentPath.TICKET);
            case 2 -> new ManufacturingCard(docData, DocumentPath.MANUFACTURING);
            default -> throw new IllegalStateException("Unexpected id card number: " + id_card_number);
        };

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "inline; filename=" + docData.getNumber() + ".docx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new InputStreamResource(card.crateDocument()));
    }
}


        /*String cardNumber = "1488";
        var customerBegin = new Employee("Попов", "13", "М");
        var contractorBegin = new Employee("Жгулев", "25", "Т");
        var customerEnd = new Employee("Попов А Ю", "8", "М");
        var contractorEnd = new Employee("Жгулев П. А.", "11", "Т");

        var data = new ManufacturingDoc(
                cardNumber,
                DeviceType.VIDEO,
                "-",
                new Interaction(customerBegin, contractorBegin, LocalDate.of(2022, Month.AUGUST, 20)),
                new Interaction(customerEnd, contractorEnd, LocalDate.of(2022, Month.DECEMBER, 20)),
                new WorkReason(Reason.JOURNAL, "18/18"),
                List.of(new DeviceDescription("Видео МЫ ДВА",
                                "AS4334JDAD",
                                "12340987323224",
                                "ПОЛНАЯ",
                                ""),
                        new DeviceDescription("Виsdasdadadsasdasdдео МЫ ДВА",
                                "AS4334JDAD",
                                "12340987323224",
                                "ПОЛНАЯ",
                                "")),
                "bag.jpeg"
        );

        final var card = switch (id) {
            case 1 -> new TicketCard(data, DocPath.TICKET);
            case 2 -> new ManufacturingCard(data, DocPath.MANUFACTURING);
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };*/


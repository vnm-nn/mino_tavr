package com.mino_tavr.controller;

import com.mino_tavr.dto.AddCardNumberRequestDto;
import com.mino_tavr.dto.AllCardNumberResponseDto;
import com.mino_tavr.dto.SingleCardNumberResponseDto;
import com.mino_tavr.service.CardNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<AllCardNumberResponseDto> getAllCardNumber(){

        return cardNumberService.getAllCardNumber();

    }

    @GetMapping(path = "/{id_card_number}")
    public SingleCardNumberResponseDto getCardNumberById(@PathVariable Integer id_card_number) {

        return cardNumberService.getCardNumberById(id_card_number);
    }

}

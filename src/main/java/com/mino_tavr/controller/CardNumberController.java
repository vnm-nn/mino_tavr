package com.mino_tavr.controller;

import com.mino_tavr.dto.AllCardNumberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/card_numbers")
@RequiredArgsConstructor
public class CardNumberController {

    @GetMapping
    public List<AllCardNumberResponseDto> getAllCardNumber(){
        return cardnumberService.getAllCardNumber();
    }
}

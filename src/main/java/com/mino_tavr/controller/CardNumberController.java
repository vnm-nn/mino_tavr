package com.mino_tavr.controller;

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
    public List<AllInteractionResponceDto> getAllInteraction(){
        return card_numberService.getAllInteraction();
    }
}

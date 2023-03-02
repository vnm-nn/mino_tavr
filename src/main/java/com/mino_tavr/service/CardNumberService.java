package com.mino_tavr.service;

import com.mino_tavr.dto.AddCardNumberRequestDto;
import com.mino_tavr.dto.AllCardNumberResponseDto;
import com.mino_tavr.dto.SingleCardNumberDto;

import java.util.List;

public interface CardNumberService {

    void add(AddCardNumberRequestDto addCardNumberRequestDto);

    List<AllCardNumberResponseDto> getAllCardNumber();

    SingleCardNumberDto getCardNumberById(Integer id);

}

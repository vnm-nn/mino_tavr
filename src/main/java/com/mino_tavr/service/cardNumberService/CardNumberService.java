package com.mino_tavr.service.cardNumberService;

import com.mino_tavr.dto.AddCardNumberRequestDto;
import com.mino_tavr.dto.AllCardNumberResponseDto;
import com.mino_tavr.dto.SingleCardNumberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardNumberService {

    void add(AddCardNumberRequestDto addCardNumberRequestDto);

    List<AllCardNumberResponseDto> getAllCardNumber();

    SingleCardNumberResponseDto getCardNumberById(Integer id);

}

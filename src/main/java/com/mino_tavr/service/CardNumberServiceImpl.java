package com.mino_tavr.service;

import com.mino_tavr.dto.AddCardNumberRequestDto;
import com.mino_tavr.dto.AllCardNumberResponseDto;
import com.mino_tavr.dto.SingleCardNumberResponseDto;
import com.mino_tavr.entity.CardNumber;
import com.mino_tavr.repository.CardNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardNumberServiceImpl implements CardNumberService{

    private final CardNumberRepository cardNumberRepository;


    @Override
    public void add(AddCardNumberRequestDto addCardNumberRequestDto) {

        CardNumber cardNumber = new CardNumber();
        cardNumber.setNumber(addCardNumberRequestDto.getNumber());


    }

    @Override
    public List<AllCardNumberResponseDto> getAllCardNumber() {
        return null;
    }

    @Override
    public SingleCardNumberResponseDto getCardNumberById(Integer id) {
        return null;
    }
}

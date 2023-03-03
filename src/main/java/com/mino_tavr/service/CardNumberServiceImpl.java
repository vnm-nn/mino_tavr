package com.mino_tavr.service;

import com.mino_tavr.dto.AddCardNumberRequestDto;
import com.mino_tavr.dto.AllCardNumberResponseDto;
import com.mino_tavr.dto.SingleCardNumberResponseDto;
import com.mino_tavr.entity.CardNumber;
import com.mino_tavr.repository.CardNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<CardNumber> all = cardNumberRepository.findAll();
    //    List<SingleCardNumberResponseDto> allCards = new ArrayList<SingleCardNumberResponseDto>();
//
    //    for (var i : all) {
    //        SingleCardNumberResponseDto singleCardNumberResponseDto = new SingleCardNumberResponseDto();
    //        singleCardNumberResponseDto.setNumber(i.getNumber());
    //        // ....
//
    //        allCards.add(singleCardNumberResponseDto);
    //    }

        return all.stream()
                .map(this::getAllCardNumberResponseDtoFromCardNumber)
                .collect(Collectors.toList());

    }

    @Override
    public SingleCardNumberResponseDto getCardNumberById(Integer id) {
        return null;
    }

    private AllCardNumberResponseDto getAllCardNumberResponseDtoFromCardNumber(CardNumber cardNumber) {
        SingleCardNumberResponseDto singleCardNumberResponseDto = new SingleCardNumberResponseDto();






        singleCardNumberResponseDto.setId_card_number(cardNumber.getId_card_number());
        singleCardNumberResponseDto.setNumber(cardNumber.getNumber());
        singleCardNumberResponseDto.setImage(cardNumber.getImage());
        singleCardNumberResponseDto.setDevice_type(cardNumber.getDevice_type());
        singleCardNumberResponseDto.setInteraction(cardNumber.getInteraction());
        singleCardNumberResponseDto.setInteraction_date_start(cardNumber.getInteraction().getInteraction_date_start());
        singleCardNumberResponseDto.setInteraction_date_end(cardNumber.getInteraction().getInteraction_date_end());
        singleCardNumberResponseDto.setDealer_start_id();
     //   allCardNumberResponseDto.set(cardNumber.get);
     //   allCardNumberResponseDto.set(cardNumber.get)
     //   allCardNumberResponseDto.set(cardNumber.get);
     //   allCardNumberResponseDto.set(cardNumber.get);
     //   allCardNumberResponseDto.set(cardNumber.get);
     //   allCardNumberResponseDto.set(cardNumber.get);
     //   allCardNumberResponseDto.set(cardNumber.get);
     //   allCardNumberResponseDto.set(cardNumber.get);



        return allCardNumberResponseDto;

    }
}

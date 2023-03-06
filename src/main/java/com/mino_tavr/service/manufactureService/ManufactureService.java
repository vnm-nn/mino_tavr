package com.mino_tavr.service.manufactureService;

import com.mino_tavr.dto.AddModelRequestDto;
import com.mino_tavr.dto.SingleModelResponseDto;

public interface ManufactureService {
    void addModel(AddModelRequestDto dataOfNewModel);
    SingleModelResponseDto getModelById(Integer modelId);

    // TODO

    // List<AllCardNumberResponseDto> getAllCardNumber();

   //  SingleCardNumberResponseDto getCardNumberById(Integer id);
}


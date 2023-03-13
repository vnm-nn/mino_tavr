package com.mino_tavr.service.manufactureService;

import com.mino_tavr.dto.AddModelRequestDto;
import com.mino_tavr.dto.ModelIdResponseDto;
import com.mino_tavr.dto.PreviewModelsResponseDto;
import com.mino_tavr.dto.SingleModelResponseDto;

import java.util.List;

public interface ManufactureService {
    ModelIdResponseDto addModel(AddModelRequestDto dataOfNewModel);
    SingleModelResponseDto getModelById(Integer modelId);
    List<PreviewModelsResponseDto> getModelsByDeviceType(Integer type);

    // TODO


    // List<AllCardNumberResponseDto> getAllCardNumber();

   //  SingleCardNumberResponseDto getCardNumberById(Integer id);
}


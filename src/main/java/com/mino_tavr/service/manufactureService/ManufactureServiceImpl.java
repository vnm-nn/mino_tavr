package com.mino_tavr.service.manufactureService;

import com.mino_tavr.broker.ImageBroker;
import com.mino_tavr.dto.*;
import com.mino_tavr.entity.*;
import com.mino_tavr.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufactureServiceImpl implements ManufactureService {
    private final ImageBroker imageBroker;
    private final ModelRepository modelRepository;


    private Description getDescriptionFromDescriptionDto(DescriptionDto descriptionData) {
        Description description = new Description();
        description.setName(descriptionData.getName());
        description.setSerialNumber(descriptionData.getSerialNumber());
        description.setInventoryNumber(descriptionData.getInventoryNumber());
        description.setRemark(descriptionData.getRemark());
        return description;
    }
    private DescriptionDto getDescriptionDtoFromDescription(Description descriptionData) {
        return new DescriptionDto(descriptionData.getName(),
                descriptionData.getSerialNumber(),
                descriptionData.getInventoryNumber(),
                descriptionData.getRemark()
        );
    }

    private InteractionDto getInteractionDtoFromInteraction(Interaction interactionData) {
        return new InteractionDto(
                Optional.ofNullable(interactionData.getDate()).map(Date::toString).orElse("-"),
                new EmployeeDto(interactionData.getDealer().getName(),
                        interactionData.getDealer().getSubdivision(),
                        interactionData.getDealer().getDepartment()),
                new EmployeeDto(interactionData.getMember().getName(),
                        interactionData.getMember().getSubdivision(),
                        interactionData.getMember().getDepartment()));
    }

    private SingleModelResponseDto getSingleModel(Model model) {
        var singleModel = new SingleModelResponseDto();

        singleModel.setId(model.getId());
        singleModel.setImage(model.getImage());
        singleModel.setDeviceType(model.getDeviceType());
        singleModel.setReason(model.getReason().getReasonType());
        singleModel.setReasonNumber(model.getReason().getReasonNumber());
        singleModel.setInteractionBegin(getInteractionDtoFromInteraction(model.getInteractionBegin()));
        singleModel.setInteractionEnd(getInteractionDtoFromInteraction(model.getInteractionEnd()));

        singleModel.setDescriptions(model.getDescriptions().stream()
                .map(this::getDescriptionDtoFromDescription)
                .collect(Collectors.toList())
        );
        return singleModel;
    }

    @Override
    public ModelIdResponseDto addModel(AddModelRequestDto dataOfNewModel) {
        // Create Interaction begin & end field
        var interactionBegin = new Interaction();
        interactionBegin.setDate(dataOfNewModel.getDate());
        interactionBegin.setDealer(new Employee(dataOfNewModel.getDealer().getName(),
                dataOfNewModel.getDealer().getSubdivision(),
                dataOfNewModel.getDealer().getDepartment()));
        interactionBegin.setMember(new Employee(dataOfNewModel.getMemberName(),
                "25",
                "Т"));

        // Date is empty (null)
        var interactionEnd = new Interaction();
        interactionEnd.setDealer(new Employee("-", "-", "-"));
        interactionEnd.setMember(new Employee("-", "-", "-"));

        // Create Reason field
        Reason reason = new Reason();
        reason.setReasonType(dataOfNewModel.getReason());
        reason.setReasonNumber(dataOfNewModel.getReasonNumber());

        // Create Model and save data(Model) to repository(DB)
        Model model = new Model();
        model.setImage(imageBroker.getDummyImageModelPreview());
        model.setDeviceType(dataOfNewModel.getDeviceType());
        model.setInteractionBegin(interactionBegin);
        model.setInteractionEnd(interactionEnd);
        model.setReason(reason);

        //Create Description fields and set to model
        model.setDescriptions(dataOfNewModel.getDescriptions().stream()
                .map(this::getDescriptionFromDescriptionDto)
                .collect(Collectors.toList()));

        return new ModelIdResponseDto(modelRepository.save(model).getId());
    }
    @Override
    public SingleModelResponseDto getModelById(Integer modelId) {
        // TODO Create exception 404 Not Found
        var model = modelRepository.findById(modelId).orElseThrow(IllegalArgumentException::new);
        return getSingleModel(model);
    }

    @Override
    public List<SingleModelResponseDto> getModelsByDeviceType(Integer type) {
        List<Model> allByType = modelRepository.findAllByDeviceType(type);
        return allByType.stream().map(this::getSingleModel).collect(Collectors.toList());
    }
}


/*

    @Override
    public List<AllCardNumberResponseDto> getAllCardNumber() {

        List<Model> all = cardNumberRepository.findAll();
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

    private AllCardNumberResponseDto getAllCardNumberResponseDtoFromCardNumber(Model cardNumber) {
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
    */

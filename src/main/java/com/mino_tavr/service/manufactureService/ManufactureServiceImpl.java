package com.mino_tavr.service.manufactureService;

import com.mino_tavr.broker.ImageBroker;
import com.mino_tavr.dto.AddModelRequestDto;
import com.mino_tavr.dto.DescriptionDto;
import com.mino_tavr.dto.EmployeeDto;
import com.mino_tavr.dto.SingleModelResponseDto;
import com.mino_tavr.entity.*;
import com.mino_tavr.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    @Override
    public void addModel(AddModelRequestDto dataOfNewModel) {
        // Create Interaction field
        Interaction interaction = new Interaction();
        interaction.setMakingStartDate(dataOfNewModel.getMakingStartDate());
        interaction.setMakingEndDate(Date.valueOf("0000-00-00"));  // Empty date of end making */
        interaction.setDealerPassed(new Employee(dataOfNewModel.getDealer().getName(),
                dataOfNewModel.getDealer().getSubdivision(),
                dataOfNewModel.getDealer().getDepartment()));
        interaction.setMemberAccepted(new Employee(dataOfNewModel.getMemberName(),
                "25",
                "Т"));

        // Empty Dealer & Member END*/
        final var blankEmployee = new Employee("-", "-", "-");
        interaction.setDealerAccepted(blankEmployee);
        interaction.setMemberPassed(blankEmployee);

        // Create Reason field
        Reason reason = new Reason();
        reason.setReasonType(dataOfNewModel.getReason());
        reason.setReasonNumber(dataOfNewModel.getReasonNumber());

        // Create Model and save data(Model) to repository(DB)
        Model model = new Model();
        model.setImg(imageBroker.getDummyImageModelPreview());
        model.setDeviceType(dataOfNewModel.getDeviceType());
        model.setInteraction(interaction);
        model.setReason(reason);
        /* Create Description fields and set to model */
        model.setDescriptions(dataOfNewModel.getDescriptions().stream()
                .map(this::getDescriptionFromDescriptionDto)
                .collect(Collectors.toList()));

        modelRepository.save(model);
    }
    @Override
    public SingleModelResponseDto getModelById(Integer modelId) {
        // TODO Create exception 404 Not Found
        final var model = modelRepository.findById(modelId).orElseThrow(IllegalArgumentException::new);
        final var singleModel = new SingleModelResponseDto();

        singleModel.setId(model.getId());
        singleModel.setImg(model.getImg());
        singleModel.setDeviceType(model.getDeviceType());
        singleModel.setReason(model.getReason().getReasonType());
        singleModel.setReasonNumber(model.getReason().getReasonNumber());
        singleModel.setMakingStartDate(model.getInteraction().getMakingStartDate());
        singleModel.setMakingEndDate(model.getInteraction().getMakingEndDate());

        singleModel.setDealerPassed(new EmployeeDto(
                model.getInteraction().getDealerPassed().getName(),
                model.getInteraction().getDealerPassed().getSubdivision(),
                model.getInteraction().getDealerPassed().getDepartment()
        ));
        singleModel.setMemberAccept(new EmployeeDto(
                model.getInteraction().getMemberAccepted().getName(),
                model.getInteraction().getMemberAccepted().getSubdivision(),
                model.getInteraction().getMemberAccepted().getDepartment()
        ));
        singleModel.setMemberPassed(new EmployeeDto(
                model.getInteraction().getMemberPassed().getName(),
                model.getInteraction().getMemberPassed().getSubdivision(),
                model.getInteraction().getMemberPassed().getDepartment()
        ));
        singleModel.setDealerAccept(new EmployeeDto(
                model.getInteraction().getDealerAccepted().getName(),
                model.getInteraction().getDealerAccepted().getSubdivision(),
                model.getInteraction().getDealerAccepted().getDepartment()
        ));

        singleModel.setDescriptions(model.getDescriptions().stream()
                .map(this::getDescriptionDtoFromDescription)
                .collect(Collectors.toList())
        );

        return singleModel;
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

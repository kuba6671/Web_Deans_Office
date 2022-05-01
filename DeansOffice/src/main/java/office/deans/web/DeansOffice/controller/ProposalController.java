package office.deans.web.DeansOffice.controller;


import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.controller.dtos.FellowShipFormDto;
import office.deans.web.DeansOffice.controller.dtos.SocialGrantFormDto;
import office.deans.web.DeansOffice.controller.mappers.FellowShipFormDtoMapper;
import office.deans.web.DeansOffice.controller.mappers.SocialGrantFormDtoMapper;
import office.deans.web.DeansOffice.model.Proposal;
import office.deans.web.DeansOffice.service.ProposalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProposalController {
    private final ProposalService proposalService;

    private SocialGrantFormDtoMapper socialGrantFormDtoMapper;

    private FellowShipFormDtoMapper fellowShipFormDtoMapper;

    @GetMapping("/SocialGrantForm")
    public List<SocialGrantFormDto> getSocialGrantForms(){
        return socialGrantFormDtoMapper.mapToSocialGrantFormDtos(proposalService.getSocialGrantForm());
    }

    @GetMapping("/FellowShipForm")
    public List<FellowShipFormDto> getFellowShipForms(){
        return fellowShipFormDtoMapper.mapToFellowShipFormDtos(proposalService.getFellowShipForm());
    }

    @PostMapping("/SocialGrantForm")
    public Proposal addSocialGrantForm(@RequestBody Proposal proposal){
        return proposalService.addSocialGrantForm(proposal);
    }

    @PostMapping("FellowShipForm")
    public Proposal addFellowShipForm(@RequestBody Proposal proposal){
        return proposalService.addFellowShipForm(proposal);
    }
}

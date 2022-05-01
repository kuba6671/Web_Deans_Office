package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Proposal;
import office.deans.web.DeansOffice.repository.InsertProposalRepository;
import office.deans.web.DeansOffice.repository.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalService {
    private final ProposalRepository proposalRepository;
    private final InsertProposalRepository insertProposalRepository;

    public List<Proposal> getSocialGrantForm(){
        String proposalName= "Stypendium socjalne";
        return proposalRepository.findProposalByProposalName(proposalName);
    }

    public List<Proposal> getFellowShipForm(){
        String proposalName = "Stypendium naukowe";
        return proposalRepository.findProposalByProposalName(proposalName);
    }

    public Proposal addSocialGrantForm(Proposal proposal){
        return insertProposalRepository.addSocialGrantForm(proposal);
    }

    public Proposal addFellowShipForm(Proposal proposal){
        return insertProposalRepository.addFellowShipForm(proposal);
    }
}

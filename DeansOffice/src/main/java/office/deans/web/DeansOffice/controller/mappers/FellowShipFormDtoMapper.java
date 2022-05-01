package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.FellowShipFormDto;
import office.deans.web.DeansOffice.model.Proposal;
import office.deans.web.DeansOffice.model.persons.Student;

import java.util.List;
import java.util.stream.Collectors;

public class FellowShipFormDtoMapper {
    private FellowShipFormDtoMapper(){}

    public static List<FellowShipFormDto> mapToFellowShipFormDtos(List<Proposal> proposals){
        return proposals.stream()
                .map(proposal -> mapToFellowShipFormDto(proposal,proposal.getStudent()))
                .collect(Collectors.toList());
    }

    private static FellowShipFormDto mapToFellowShipFormDto(Proposal proposal, Student student){
        return FellowShipFormDto.builder()
                .proposalID(proposal.getProposalID())
                .proposalName(proposal.getProposalName())
                .proposalDate(proposal.getProposalDate())
                .academicSession(proposal.getAcademicSession())
                .markAVG(proposal.getMarkAVG())
                .decision(proposal.getDecision())
                .indexNumber(student.getIndexNumber())
                .build();
    }
}

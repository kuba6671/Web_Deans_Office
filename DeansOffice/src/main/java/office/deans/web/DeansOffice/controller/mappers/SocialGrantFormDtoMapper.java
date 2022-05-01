package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.SocialGrantFormDto;
import office.deans.web.DeansOffice.model.Proposal;
import office.deans.web.DeansOffice.model.persons.Student;

import java.util.List;
import java.util.stream.Collectors;

public class SocialGrantFormDtoMapper {
    private SocialGrantFormDtoMapper(){}

    public static List<SocialGrantFormDto> mapToSocialGrantFormDtos(List<Proposal> proposals){
            return proposals.stream()
                    .map(proposal -> mapToSocialGrantFormDto(proposal,proposal.getStudent()))
                    .collect(Collectors.toList());
    }

    private static SocialGrantFormDto mapToSocialGrantFormDto(Proposal proposal, Student student){
        return SocialGrantFormDto.builder()
                .proposalID(proposal.getProposalID())
                .proposalName(proposal.getProposalName())
                .proposalDate(proposal.getProposalDate())
                .academicSession(proposal.getAcademicSession())
                .income(proposal.getIncome())
                .decision(proposal.getDecision())
                .indexNumber(student.getIndexNumber())
                .build();
    }
}

package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Long> {
    List<Proposal> findProposalByProposalName(String proposalName);
}

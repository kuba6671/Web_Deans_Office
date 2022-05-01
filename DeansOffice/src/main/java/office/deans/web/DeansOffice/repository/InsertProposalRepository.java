package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Proposal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class InsertProposalRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Proposal addSocialGrantForm(Proposal proposal) {
         entityManager.createNativeQuery("INSERT INTO PROPOSAL" +
                        "(PROPOSALID,PROPOSALNAME,ProposalDate,ACADEMICSESSION,INCOME,INDEXNUMBER,DECISION)" +
                        " VALUES(PROPOSAL_SEQ.nextval,?,?,?,?,?,?)")
                .setParameter(1,"Stypendium socjalne")
                .setParameter(2,proposal.getProposalDate())
                .setParameter(3,proposal.getAcademicSession())
                .setParameter(4,proposal.getIncome())
                .setParameter(5,proposal.getStudent().getIndexNumber())
                .setParameter(6,"Oczekujace")
                .executeUpdate();
        return proposal;
    }

    @Transactional
    public Proposal addFellowShipForm(Proposal proposal) {
        entityManager.createNativeQuery("INSERT INTO PROPOSAL" +
                        "(PROPOSALID,PROPOSALNAME,ProposalDate,ACADEMICSESSION,MARKAVG,INDEXNUMBER,DECISION)" +
                        " VALUES(PROPOSAL_SEQ.nextval,?,?,?,?,?,?)")
                .setParameter(1,"Stypendium naukowe")
                .setParameter(2,proposal.getProposalDate())
                .setParameter(3,proposal.getAcademicSession())
                .setParameter(4,proposal.getMarkAVG())
                .setParameter(5,proposal.getStudent().getIndexNumber())
                .setParameter(6,"Oczekujace")
                .executeUpdate();
        return proposal;
    }
}

package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Exam;
import office.deans.web.DeansOffice.repository.ExamRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    public List<Exam> getStudentExams(Long groupID, Sort.Direction sort){
        return examRepository.findExamByGroup_GroupID(groupID,Sort.by(sort,"examDate"));
    }

}

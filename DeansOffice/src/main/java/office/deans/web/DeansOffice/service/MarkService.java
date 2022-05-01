package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;

     public List<Mark> getStudentMarks(Long indexNumber){
        return markRepository.findMarkByStudent_IndexNumber(indexNumber);
    }

    public Mark addMark(Mark mark) {
        return markRepository.save(mark);
    }
}

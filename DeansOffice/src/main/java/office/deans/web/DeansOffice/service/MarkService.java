package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;

    public List<Mark> getStudentMarks(Long indexNumber){
        return markRepository.findMarkByIndexNumber(indexNumber);
    }

    public Mark addMark(Mark mark) {
        return markRepository.save(mark);
    }
}

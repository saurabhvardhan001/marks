package candidateController;

import subjects.ArrayList;
import subjects.Candidate;
import subjects.Controller;
import subjects.Create;
import subjects.GetMapping;
import subjects.List;
import subjects.PathVariable;
import subjects.PostConstruct;
import subjects.RestController;


@RestController
@RequestMapping("/candidates")
public class CandidateController {

    
    private List<Candidate> candidates = new ArrayList<>();

    
    @PostConstruct
    public void init() {
        candidates.add(new Candidate("2021001", "Mathematics", 95, "John Doe"));
        candidates.add(new Candidate("2021002", "Physics", 88, "Jane Smith"));
    }

    @GetMapping("/{enrollmentNumber}")
    public Candidate getCandidateByEnrollmentNumber(@PathVariable String enrollmentNumber) {
        for (Candidate candidate : candidates) {
            if (candidate.getEnrollmentNumber().equals(enrollmentNumber)) {
                return candidate;
            }
        }
        return null; 
    }
}


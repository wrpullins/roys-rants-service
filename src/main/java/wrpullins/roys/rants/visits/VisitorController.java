package wrpullins.roys.rants.visits;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrpullins.roys.rants.visits.dto.PageVisit;
import wrpullins.roys.rants.visits.service.VisitService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/visit")
public class VisitorController {

    private final VisitService visitService;
    @PostMapping
    public void visit(@RequestBody PageVisit visitInformation){
        visitService.visit(visitInformation);
    }
}

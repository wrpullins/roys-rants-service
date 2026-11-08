package wrpullins.roys.rants.visits.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wrpullins.roys.rants.visits.dto.PageVisit;

import java.time.LocalDateTime;

@Service
public class VisitService {

    private final VisitorRepository visitorRepository;
    private final PageViewRepository pageVisitRepository;

    public VisitService(
            VisitorRepository visitorRepository,
            PageViewRepository pageVisitRepository) {
        this.visitorRepository = visitorRepository;
        this.pageVisitRepository = pageVisitRepository;
    }

    @Value("${roys.rants.counters}")
    private String countersOn;
    public void visit(final PageVisit visit){


        if(countersOn == "on") {
            var visitor = visitorRepository.findByVisitorKey(visit.getVisitorId());

            if (visitor.isEmpty()) {
                var newVisitor = VisitorDbo.builder()
                        .visitorKey(visit.getVisitorId())
                        .userAgent(visit.getUserAgent())
                        .firstSeenAt(LocalDateTime.now())
                        .lastSeenAt(LocalDateTime.now())
                        .build();

                visitorRepository.save(newVisitor);
            }

            var updatedVisitor = visitor.get().toBuilder()
                    .lastSeenAt(LocalDateTime.now())
                    .build();

            visitorRepository.save(updatedVisitor);

            var newPageVisit = PageViewDbo.builder()
                    .visitorKey(updatedVisitor.getVisitorKey())
                    .pagePath(visit.getPath())
                    .viewedAt(LocalDateTime.now())
                    .build();

            pageVisitRepository.save(newPageVisit);
        }
    }
}

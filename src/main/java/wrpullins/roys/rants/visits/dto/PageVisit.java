package wrpullins.roys.rants.visits.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageVisit {
    private String visitorId;
    private String userAgent;
    private String path;
}

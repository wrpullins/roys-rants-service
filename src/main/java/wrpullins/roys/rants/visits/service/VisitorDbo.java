package wrpullins.roys.rants.visits.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visitor")
public class VisitorDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String visitorKey;
    private String userAgent;
    private LocalDateTime firstSeenAt;
    private LocalDateTime lastSeenAt;
}

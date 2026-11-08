package wrpullins.roys.rants.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtToken {
	private String token;
}

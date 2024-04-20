
package SpotifyOauth2.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@Jacksonized

public class Followers {
     Object href;
     Integer total;
}

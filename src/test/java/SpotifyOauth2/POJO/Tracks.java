
package SpotifyOauth2.POJO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@Jacksonized

public class Tracks {
     String href;
     List<Object> items;
     Integer limit;
     Object next;
     Integer offset;
     Object previous;
     Integer total;
}

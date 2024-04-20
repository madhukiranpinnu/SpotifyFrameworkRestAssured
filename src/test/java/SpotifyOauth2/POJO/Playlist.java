
package SpotifyOauth2.POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@Jacksonized
public class Playlist {
     Boolean collaborative;
     String description;
     ExternalUrls external_urls;
     Followers followers;
     String href;
     String id;
     Object images;
     String name;
     Owner owner;
     Object primary_color;
     @JsonProperty("public")
     Boolean _public;
     String snapshot_id;
     Tracks tracks;
     String type;
    String uri;
}

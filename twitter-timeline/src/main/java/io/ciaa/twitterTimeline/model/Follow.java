package io.ciaa.twitterTimeline.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.ciaa.twitterTimeline.FollowDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Getter
@Setter

public class Follow implements Serializable {

    @Id
    Long id;

    private Long follower;

    private Long followed;
}

package rin.k_craft_beer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="brewery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brewery {
    @Id
    private String id; // 숫자 _id

    private String name;
    private GeoJsonPoint location;  // // type: "Point", coordinates: [lng, lat]
    private String image;
    private String homepage;
}

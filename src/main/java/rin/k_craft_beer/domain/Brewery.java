package rin.k_craft_beer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="brewery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brewery {
    @Id
    private String id; // MongoDB에는 자동 증가가 없기 때문에 기본 _id 사용

    private String name;
    private GeoJsonPoint location;  // // type: "Point", coordinates: [lng, lat]
    private String image;
    private String homepage;
}

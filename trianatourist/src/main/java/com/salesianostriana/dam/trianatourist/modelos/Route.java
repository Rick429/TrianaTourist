package com.salesianostriana.dam.trianatourist.modelos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Route {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "route_id",
            foreignKey = @ForeignKey(name="FK_STEPS_ROUTE")),
            inverseJoinColumns = @JoinColumn(name = "poi_id",
                    foreignKey = @ForeignKey(name="FK_STEPS_POI")),
            name = "steps"
    )
    private List<POI>steps;
}

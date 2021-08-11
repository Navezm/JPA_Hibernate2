package be.technobel.formation.iris.hibernate.model;

import lombok.Data;

import java.time.Instant;

@Data
public class TestLombok {

    private Long id;
    private String name;
    private Instant date;

}

package org.me.learning.quizmicros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

//    if we have numbers or specific type we use ElementCollection , but if we have entity type
//    or different table we use @ManyToMany like question
    @ElementCollection
    private List<Integer> questionIds;

}
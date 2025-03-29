package org.me.learning.quizmicros.model;

import lombok.Data;

@Data
public class QuizDto {
//          Data Transfer Object
    String categoryName;
    Integer numQuestions;
    String title;
}
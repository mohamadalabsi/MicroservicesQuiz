package org.me.learning.quizmicros.service;

import org.me.learning.quizmicros.feign.QuizInterface;
import org.me.learning.quizmicros.model.QuestionWrapper;
import org.me.learning.quizmicros.model.Quiz;
import org.me.learning.quizmicros.model.Response;
import org.me.learning.quizmicros.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//  !       this will interact with the question Service to get the question as an admin

//        her i want to call the generate url from question service , we should use rest template from spring and the url http:...../question/generate
//         but with the local host or the domain name it is not the best solution , thats why we use other 2 different services (feign client , service discovery(eureka) ) instead of rest template
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}

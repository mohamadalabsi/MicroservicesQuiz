package org.me.learning.quizmicros.feign;


import org.me.learning.quizmicros.model.QuestionWrapper;
import org.me.learning.quizmicros.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONMICROS") // here we mention which service (client)
public interface QuizInterface {
//    now feign used after registering all services with eureka server to allow it to search for
//    other services and call them
//     we have to declare the methods not define


//!    feign client also work as load balancer during communicating and searching for the
//!    services we need so if an instance is busy from other service it will use another
//! so in a way it is internal load balancer

//     we put question/generate and look back to QUESTIONMICROS it is different but work the same
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions );

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}

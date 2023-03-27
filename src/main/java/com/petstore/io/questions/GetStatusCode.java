package com.petstore.io.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class GetStatusCode implements Question {
    @Override
    public Integer answeredBy(Actor actor) {
      return SerenityRest.lastResponse().statusCode();
    }

    @Override
    public String getSubject() {
        return Question.super.getSubject();
    }

    public static Question<Integer> was (){
        return new GetStatusCode();
    }
}

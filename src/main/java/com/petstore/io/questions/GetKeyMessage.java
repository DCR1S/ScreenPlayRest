package com.petstore.io.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetKeyMessage implements Question {

    private String key;

    public GetKeyMessage(String key){
        this.key=key;
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().jsonPath().getString(key);
    }

    public static GetKeyMessage was (String key){
        return new GetKeyMessage(key);
    }
}

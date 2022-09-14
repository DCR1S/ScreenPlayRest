package com.petstore.io.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class BaseEndPointConfiguration implements Interaction {

    private String endPoint;
    public BaseEndPointConfiguration(String endPoint){
        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(endPoint));
    }

    public static BaseEndPointConfiguration on (String endPoint){
        return new BaseEndPointConfiguration(endPoint);
    }

}

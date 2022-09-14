package com.petstore.io.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class DoGet implements Task {
    private String relativeEndPoint;

    public DoGet(String relativeEndPoint) {
        this.relativeEndPoint = relativeEndPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(relativeEndPoint));
    }

    public static DoGet on (String relativeEndPoint){
        return new DoGet(relativeEndPoint);
    }
}

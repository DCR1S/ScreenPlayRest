package com.petstore.io.tasks;

import com.petstore.io.interactions.BaseEndPointConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class DoPost implements Task {

    private String relativeEndPoint;
    private String body;
    public DoPost(String endPoint, String body){
        this.relativeEndPoint = endPoint;
        this.body = body;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(relativeEndPoint).with(request -> request.header("Content-Type","application/json").header("accept","*/*").body(body)));
    }
    public static DoPost on (String relativeEndPoint, String body){
        return new DoPost(relativeEndPoint,body);
    }
}

package com.petstore.io.stepdefinitions;

import com.petstore.io.interactions.BaseEndPointConfiguration;
import com.petstore.io.questions.GetKeyMessage;
import com.petstore.io.questions.GetStatusCode;
import com.petstore.io.tasks.DoPost;
import com.petstore.io.utils.SpecialMethods;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class ServiceStepDefinitions {

    @Before
    public void actorSetUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cristian");
    }

    @Given("que me encuentro con la uri de petstore {string}")
    public void queMeEncuentroConLaUriDePetstore(String endPoint) {
        theActorInTheSpotlight().attemptsTo(BaseEndPointConfiguration.on(endPoint));
    }

    @When("realice el crud de los servicios")
    public void realiceElCrudDeLosServicios() {
        SpecialMethods.configProperties();
        theActorInTheSpotlight().attemptsTo(DoPost.on(SpecialMethods.properties.getProperty("relativeEndPoint"),SpecialMethods.properties.getProperty("bodyRequest")));
    }

    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(Integer responseCode) {
        theActorInTheSpotlight().should(
                seeThat("El codigo de respuesta", GetStatusCode.was(), equalTo(responseCode))
        );

    }

    @Then("valido que la llave {string} no este vacia")
    public void validoQueLaLlaveNoEsteVacia(String llave) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje en la llave", GetKeyMessage.was(llave), Matchers.is(Matchers.notNullValue()))
        );
    }

}

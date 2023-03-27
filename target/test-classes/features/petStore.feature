Feature: Servicio rest con serenity
  @service
  Scenario: servicio rest petstore
    Given que me encuentro con la uri de petstore "https://petstore.swagger.io/"
    When realice el crud de los servicios
    Then valido que el codigo de respuesta sea 200
    And valido que la llave "message" no este vacia
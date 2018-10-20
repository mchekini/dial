package com.performance_Testing


import io.gatling.core.Predef._
import io.gatling.http.Predef._

class FirstSimulation extends Simulation {

    val httpProtocol = http.baseURL("http://localhost:8080").inferHtmlResources()
    val scn = scenario("repeat test").repeat(10) {
      exec(http("Home").get("/test"))
    }
    setUp(scn.inject(rampUsers(10) over(1)).protocols(httpProtocol))
  }

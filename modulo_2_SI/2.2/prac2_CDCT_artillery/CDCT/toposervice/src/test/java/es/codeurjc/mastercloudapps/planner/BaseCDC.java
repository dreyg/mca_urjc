package es.codeurjc.mastercloudapps.planner;


import es.codeurjc.mastercloudapps.planner.controller.TopoController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseCDC {

    @Autowired
    TopoController topoController;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(topoController);
    }
}

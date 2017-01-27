package com.areo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by gta on 27.01.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerIT {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private URL base;

    @Before
    public void setUp() throws Exception{
        this.base = new URL("http://localhost:" + this.port);
    }

    @Test
    public void checkIndexPage() throws Exception{
        ResponseEntity<String> entity = template.getForEntity(base.toString(), String.class);

        assertThat(entity.getBody(), equalTo("isOk"));
    }


}

package com.example.project;

import com.example.project.repositories.ModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProjectApplicationTests {

    @Autowired
    private ModelRepository modelRepository;

    @Test
    void contextLoads() {
    }

}

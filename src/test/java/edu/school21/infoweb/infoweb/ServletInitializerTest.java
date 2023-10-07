package edu.school21.infoweb.infoweb;

import edu.school21.infoweb.InfoWeb2Application;
import edu.school21.infoweb.ServletInitializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServletInitializerTest {
    @Mock
    private SpringApplicationBuilder springApplicationBuilder;
    @Test
    void configure() {
        ServletInitializer servletInitializer = new ServletInitializer();
        when(springApplicationBuilder.sources(InfoWeb2Application.class)).thenReturn(springApplicationBuilder);

        SpringApplicationBuilder result = servletInitializer.configure(springApplicationBuilder);

        verify(springApplicationBuilder).sources(InfoWeb2Application.class);
        assertEquals(springApplicationBuilder,result);
    }
}
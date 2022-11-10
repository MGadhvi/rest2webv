package com.mg.r2wv.view;

import com.mg.r2wv.model.ChuckDTO;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Route
public class MainView extends HorizontalLayout {
    public MainView() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ChuckDTO> entity = restTemplate.getForEntity(new URI("https://api.chucknorris.io/jokes/random"), ChuckDTO.class);
            add(new Text(Objects.requireNonNull(entity.getBody()).getValue()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

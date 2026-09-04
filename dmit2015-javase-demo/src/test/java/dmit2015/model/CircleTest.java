package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class CircleTest {

    @Test
    void area_whenCircleIsCreatedWithRadius5_shouldReturnCorrectArea() {
        Circle circle = new Circle(5);
        assertThat(circle.area()).isCloseTo(78.54, within(0.01));
    }
}
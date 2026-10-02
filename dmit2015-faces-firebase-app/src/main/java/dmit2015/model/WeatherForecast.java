package dmit2015.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Getter
@Setter
@NoArgsConstructor
public class WeatherForecast {

    private String id;

    @Future(message = "Date must be in the future")
    @NotNull(message = "Date is required")
    private LocalDate date;

    @Min(value = -20,message = "Celisus must be between -20 and 50")
    @Max(value = 50,message = "Celisus must be between -20 and 50")
    private int temperatureC;

    private String summary;

    public int getTemperatureF() {
        return (int) (32 + temperatureC / 0.5556);
    }

    public static WeatherForecast of(Faker faker) {
        WeatherForecast currentWeatherForecast = new WeatherForecast();
        currentWeatherForecast.setId(UUID.randomUUID().toString());
        currentWeatherForecast.setDate(LocalDate.now().plusDays(RandomGenerator.getDefault().nextInt(1, 6)));
        currentWeatherForecast.setTemperatureC(faker.number().numberBetween(-20,50));
        currentWeatherForecast.setSummary(faker.weather().description());
        return currentWeatherForecast;
    }

    public static WeatherForecast copyOf(WeatherForecast other) {
        return new WeatherForecast(other);
    }

    public WeatherForecast(WeatherForecast other) {
        id = other.getId();
        date = other.getDate();
        summary = other.getSummary();
        temperatureC = other.getTemperatureC();
    }
}

package dmit2015.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GreetingBean {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGreetingMessage() {
        if (firstName == null || firstName.isBlank()) {
            return "";
        }

        //return "Welcome " + firstName + " to DMIT2015!";
        return String.format("Welcome %s to DMIT2015!", firstName);
    }
}

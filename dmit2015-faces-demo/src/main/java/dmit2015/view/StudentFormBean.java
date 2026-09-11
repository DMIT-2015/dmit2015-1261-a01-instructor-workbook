package dmit2015.view;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class StudentFormBean implements Serializable {

    private int submissionCount;
    private String fullName;
    private String program;
    private boolean fullTime;

    public void submit() {
        submissionCount++;
        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Form Submitted",
                "Welcome " + fullName + " from " + program
        );
        FacesContext.getCurrentInstance()
                .addMessage(null, message);

    }
    public int getSubmissionCount() {
        return submissionCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
}

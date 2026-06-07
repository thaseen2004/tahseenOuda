package firstProject.example.tahseenOuda.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "major", "grade"})
public class StudentRequest {

    private final Long id;
    private final String name;
    private final String major;
    private final String grade;

    @JsonCreator
    public StudentRequest(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("major") String major,
            @JsonProperty("grade") String grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }
}

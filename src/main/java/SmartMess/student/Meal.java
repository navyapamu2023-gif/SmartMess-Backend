package SmartMess.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Breakfast status is required")
    @Pattern(regexp = "^(Eat|Skip)$", message = "Breakfast must be either Eat or Skip")
    @Column(nullable = false)
    private String breakfast;

    @NotBlank(message = "Lunch status is required")
    @Pattern(regexp = "^(Eat|Skip)$", message = "Lunch must be either Eat or Skip")
    @Column(nullable = false)
    private String lunch;

    @NotBlank(message = "Snacks status is required")
    @Pattern(regexp = "^(Eat|Skip)$", message = "Snacks must be either Eat or Skip")
    @Column(nullable = false)
    private String snacks;

    @NotBlank(message = "Dinner status is required")
    @Pattern(regexp = "^(Eat|Skip)$", message = "Dinner must be either Eat or Skip")
    @Column(nullable = false)
    private String dinner;

    public Meal() {
    }

    public Meal(String email, String breakfast, String lunch, String snacks, String dinner) {
        this.email = email;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.snacks = snacks;
        this.dinner = dinner;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }
}
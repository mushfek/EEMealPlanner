package domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/16/13
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "meal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "day")
    private String day;

    @Column(name = "breakfast")
    private String breakfast;

    @Column(name = "lunch")
    private String lunch;

    @Column(name = "snacks")
    private String snacks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
}

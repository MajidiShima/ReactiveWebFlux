package ir.sharif.reactivewebflux.course;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Table("course")
public class Course {
    @Id
    private Long id;

    @Column("title")
    private String title;

    @Column("unit")
    private Integer unit;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUnit() {
        return unit;
    }

    public Course() {
    }
}

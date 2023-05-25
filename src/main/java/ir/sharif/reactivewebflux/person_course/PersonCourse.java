package ir.sharif.reactivewebflux.person_course;

import ir.sharif.reactivewebflux.course.Course;
import ir.sharif.reactivewebflux.person.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("person_course")
public class PersonCourse {
    @Id
    private Long id;


    @Column("course_id")
    private Long courseId;

    @Transient
    private Course course;

    @Column("person_id")
    private Long personId;

    @Transient
    private Person person;

    public PersonCourse() {
    }

    public PersonCourse(Long id) {
        this.id = id;
    }

    public PersonCourse(Long id, Long courseId, Long personId) {
        this.id = id;
        this.courseId = courseId;
        this.personId = personId;
    }
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    @ManyToOne
//    @JoinColumn(name = "person_id")
//    private Person person;


    @Override
    public String toString() {
        return "PersonCourse{" +
                "id="+id+
                ", courseId="+ courseId+
                ", course="+ course +
                ", personId="+ personId+
                ", person="+ person +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

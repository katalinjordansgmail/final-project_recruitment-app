package com.ironhack.model;

import com.ironhack.model.enums.JobStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
public class Job {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="id")
    private User hiringManager;
    @ManyToOne
    @JoinColumn(name="id")
    private User recruiter;
    private String jobTitle;
    private String jobDescription;
    @Enumerated(EnumType.STRING)
    private JobStatus status;
    @OneToMany(mappedBy="job")
    private Set<Application> applications;
    private Date openDate;
    private Date closeDate;

}

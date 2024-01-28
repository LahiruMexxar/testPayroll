package com.LV8.Test.Models;

import com.LV8.Test.Enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="should be filled")
    private String firstName;

    @NotBlank(message ="should be filled")
    private String lastName;

    @NotBlank(message ="should be filled")
    private Long contactNumber;

    @NotBlank(message ="should be filled")
    private String email;

    @NotBlank(message ="should be filled")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message ="should be filled")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

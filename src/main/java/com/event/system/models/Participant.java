package com.event.system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "participants")
public class Participant{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        @Column(nullable = false, name = "name",length = 150)
        private String name;

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve ser válido")
        @Column(nullable = false, name = "email", unique = true,length = 150)
        private String email;

        @Max(value = 130, message = "A idade não pode ser maior que 130 anos")
        @Min(value = 0, message = "A idade não pode ser negativa")
        @Column(nullable = false, name = "age")
        private int age;

        public Participant(String name, String email, int age) {
                this.name = name;
                this.email = email;
                this.age = age;
        }

        public Participant() {
        }

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

        public int getAge() {
                return age;
        }

        @Override
        public String toString() {
                return "Participant{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", age=" + age +
                        '}';
        }
}

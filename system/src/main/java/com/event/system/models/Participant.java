package com.event.system.models;

import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participant{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, name = "name")
        private String name;
        @Column(nullable = false, name = "email")
        private String email;
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

package com.event.system.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "events")
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
        }

        public Participant() {
        }
}

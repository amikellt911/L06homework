package org.example.text_test.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

    @Column(nullable = false,unique = true)
    private String title;
    @Column(nullable = false)
    private String body;
}

package com.example.samuraitravel.entity;


	import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity
	@Table(name = "faqs")
	@Getter
	@Setter
	@NoArgsConstructor
	public class Faq {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false, length = 255)
	    private String question;

	    @Column(nullable = false, length = 255)
	    private String answer;

	    @CreationTimestamp
	    @Column(name = "created_at", updatable = false)
	    private LocalDateTime createdAt;

	    @UpdateTimestamp
	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	}



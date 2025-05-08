package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq_gen")
	@SequenceGenerator(name = "answer_seq_gen", sequenceName = "answer_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "content", columnDefinition = "CLOB", nullable = false)
	private String content;
	
	@Column(name = "createDate", nullable = false)
	private LocalDateTime createDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;
}

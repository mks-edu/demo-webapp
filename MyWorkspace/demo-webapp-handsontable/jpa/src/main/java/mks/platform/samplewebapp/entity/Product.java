package mks.platform.samplewebapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="samplewebapp_product")
@Getter @Setter
@AllArgsConstructor
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name", length = 64)
	private String name;

	@Column(name="product_number", length = 64)
	private String productNumber;
	
	@Column(name="color", length = 16)
	private String color;

}
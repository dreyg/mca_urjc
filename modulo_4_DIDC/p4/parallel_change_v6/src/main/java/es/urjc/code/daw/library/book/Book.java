package es.urjc.code.daw.library.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;
	private String title;
	private String preface;
	private Integer priceint;
	private Float price;


	public Book() {}

	public Book(String nombre, String preface) {
		super();
		this.title = nombre;
		this.preface = preface;
	}


	public Book(String nombre, String preface, Integer priceint) {
		super();
		this.title = nombre;
		this.preface = preface;
		this.priceint = priceint;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPriceint() {
		return this.priceint;
	}

	public void setPriceint(Integer priceint) {
		this.priceint = priceint;
		this.price = (float) (priceint);
	}

	public Float getPrice() {

		if (this.price != null){
			return this.price;
		}else{
			if (this.priceint != null){
				return (float) this.priceint;
			}
		}
		return null;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getPreface(){
		return this.preface;
	}

	public void setPreface(String preface){
		this.preface = preface;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", preface=" + preface + ", priceint= "+priceint+" ]";
	}

}

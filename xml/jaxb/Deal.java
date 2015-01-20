package xml.jaxb;

import javax.xml.bind.annotation.*;

public class Deal {
//@XmlAttribute	
Integer price;

String name;
//@XmlAttribute	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
//	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

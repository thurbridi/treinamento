package autopractice.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

	private String name;
	private float price;
	private List<String> colors;

}

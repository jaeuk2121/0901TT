package projectdb.pb.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
	private String code;
	private String name;
	private String detail;
	private int price;
	private int sale;
}

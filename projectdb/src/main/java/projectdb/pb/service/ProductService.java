package projectdb.pb.service;

import java.util.List;

public interface ProductService {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
}

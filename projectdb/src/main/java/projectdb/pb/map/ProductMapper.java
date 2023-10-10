package projectdb.pb.map;

import java.util.List;

import projectdb.pb.service.ProductVO;

public interface ProductMapper {
	List<ProductVO> productSelectList();

	ProductVO productSelect(ProductVO vo);
}

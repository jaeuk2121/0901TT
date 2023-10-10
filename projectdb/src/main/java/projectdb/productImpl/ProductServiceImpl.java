package projectdb.productImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import projectdb.common.DataSource;
import projectdb.pb.map.ProductMapper;
import projectdb.pb.service.ProductService;
import projectdb.pb.service.ProductVO;

public class ProductServiceImpl implements ProductService {
private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ProductMapper map = sqlSession.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> productSelectList() {
		// TODO Auto-generated method stub
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productSelect(vo);
	}

}

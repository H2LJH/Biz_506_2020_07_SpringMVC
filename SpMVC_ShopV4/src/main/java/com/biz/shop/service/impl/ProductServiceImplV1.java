package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.ProductVO;
import com.biz.shop.persistence.ProductDAO;
import com.biz.shop.service.ProductService;

import lombok.extern.slf4j.Slf4j;


/*
 * ProductService 인터페이스는 GenericService 인터페이스를 상속(extends)하므로서
 * CRUD 기본 method를 별도로 선언하지 않아도 된다.
 * 필요한 추가 method가 있으면 별도로 선언을 해주고 
 * 이 interface를 implements한 클래스는 인터페이스의 영향을 받아 method를 구현하게 된다.
 */

@Slf4j
@Service(value="proServiceV1")
public class ProductServiceImplV1 implements ProductService 
{
	@Autowired
	private ProductDAO proDAO;
	
	
	@Override
	public List<ProductVO> selectAll() 
	{
		return proDAO.selectAll();
	}

	@Override
	public ProductVO findById(String id) 
	{
		return proDAO.findById(id);
	}

	@Override
	public int insert(ProductVO vo) 
	{
		vo.setP_image("이미지 없음");
		int ret = proDAO.insert(vo);
		
		if(ret >0)
			log.debug("INSERT 성공 {} 개 데이터 추가", ret);
		
		else
			log.debug("INSERT 실패 {}", ret);
		
		return ret;
	}

	@Override
	public int update(ProductVO vo) 
	{
		// Update를 수행하기 전에 삭제 Flag칼럼을 강제로 null로 설정하여
		// 해당 상품이 삭제 표시가 되지 않도록 하여 놓는다.
		vo.setP_not_use(null);
		int ret = proDAO.update(vo);
		return ret;
	}

	
	/*
	 * 상품정보, 거래처정보, 회원정보 와  같은 데이터를 통상 Master Data라고 한다
	 * 마스터 데이터는 Work Data(Master Data는 매입매출, 거래처 외상 정보, 회원 로그인 로그)와 같은
	 * 기준이 되는 되는 값을 가지는 Data Table들이다.
	 *  어플을 사용해서 어떤 업무를 진행하는 과정에서
	 *  WorkData에 저장되는 데이터는 필수적으로 Master Data와 Join관계가 맺어진다.
	 *  만약 WorkData와 Master Date를 join하여 어떤 통게정보를 찾고자 할때
	 *  Master에 해당하는 데이터(코드와 일치하는)가 없으면
	 *  WorkData의 정보가 어떤내용인지 확인이 어려워지는 경우가 많다.
	 *  
	 *  통상적으로 Master Data는 원칙상 PK 칼럼 값은 변경하지 않고 
	 *  또한 한번 Insert된  Master Data는 삭제하지 않는다.
	 *  필요가 없어진(앞으로 사용하지 않을) 데이터는  table에서 delete를 하지 않고 특정한 칼럼을 한개 지정하여
	 *  그 칼럼에 flag를 세팅하고 삭제되었음을 표시한다.
	 *  
	 *  1. id(p_code)로 table에서 데이터를 조회하여 VO에 담고
	 *  2. VO의 p_not_use 칼럼을 null이 아닌 값으로 세팅하여
	 *  3. update를 수행한다.
	 *  4. SELECT를 수행할때 p_not_use 칼럼이 NULL 데이터만 조회하여
	 *  5. 삭제된 데이터는 제외하고 조회할수 있도록 코드를 변경한다.
	 */
	@Override
	public int delete(String id) 
	{
		int ret = 0;
		ProductVO proVO = proDAO.findById(id);
		if(proVO != null)
		{	
			proVO.setP_not_use((byte)1);
			ret = proDAO.update(proVO);
		}
		
		// Controller에서 delete() method를 실행한 후 결과값을 보고
		// DELETE가 성공했는지 안했는지를 판단
		return ret;
	}

	@Override
	public List<ProductVO> findByTitle(String title) 
	{
		return null;
	}

	@Override
	public String getPCode() 
	{
		/*
		   tbl_product table에서 상품코드를 조회하는데 가장 큰값의 코드를 가져와라
		     그중에 P0010코드를 가져오는 SQL을 만들겠다.
		*/
		String strMaxPCode = proDAO.maxPCode();
		log.debug("조회한 상품코드 : {}", strMaxPCode);
		
		
		
		String retPCode = "P00001";
		try {
				String preCode = strMaxPCode.substring(0, 1);
				String pCode = strMaxPCode.substring(1);
				log.debug("분리된 상품코드 {}, {}", preCode, pCode);
				retPCode = String.format("%s%05d", preCode, Integer.valueOf(pCode) + 1); 
			} 
		catch (Exception e) {}
		log.debug("새로 생성된 상품코드 {}", retPCode);
		
		return retPCode;
	}
	
}

package spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository//Dao로 정의
public class BoardDaoMybatis implements BoardDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoMybatis(SqlSessionTemplate sessionTemplate) {
		this.sqlSessionTemplate = sessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("boardDao.list");
	}
	
	@Override
	public int delete(BoardVO boardVO) {
		return sqlSessionTemplate.delete("boardDao.delete", boardVO);
	}
	
	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("boardDao.deleteAll");
	}
	
	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("boardDao.update", boardVO);
	}
	
	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("boardDao.insert", boardVO);
	}
	
	@Override
	public BoardVO select(int seq) {
		BoardVO vo = sqlSessionTemplate.selectOne("boardDao.select", seq);
		return vo;
	}
	
	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("boardDao.updateCount", seq);
	}
	
}

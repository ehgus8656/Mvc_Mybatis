package spring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	public MemberDaoImpl() {}
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public List<Member> selectAll() {
		return sqlSessionTemplate.selectList("memberDao.list");
	}
	@Override
	public void insert(Member member) {
		sqlSessionTemplate.insert("memberDao.insert", member);
	}
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("memberDao.count");
	}
	@Override
	public void update(Member member) {
		sqlSessionTemplate.update("memberDao.update", member);
	}
	@Override
	public Member selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("memberDao.selectByEmail", email);
	}
	@Override
	public Member selectById(Long Id) {
		List<Member> result = sqlSessionTemplate.selectList("memberDao.selectById", Id);
		return result.isEmpty() ? null : result.get(0);
	}
	@Override
	public List<Member> selectByRegDate(Date from, Date to) {
		HashMap<String, Date> map = new HashMap<String, Date>();
		map.put("from", from);
		map.put("to", to);
		return sqlSessionTemplate.selectList("memberDao.selectByRegdate", map);
	}
}
package kr.or.ddit.ioc.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class CollectionBean {
	private List list;
	private Set sets;
	private Map map;
	private Properties pros;

	//spring 설정 파일을 통해 주입 받는 방법
	//1. constructor: 생성자를 통한 주입
	//2. setter : setter를 통한 주입
	
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSets() {
		return sets;
	}
	public void setSets(Set sets) {
		this.sets = sets;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getPros() {
		return pros;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	
	
	
	
}

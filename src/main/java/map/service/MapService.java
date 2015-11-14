package map.service;

import java.util.List;

import map.domain.Map;

public interface MapService {
	public List<Map> getAll();
	
	public void save(Map d);
	
	public Map findMap(Integer Id);
	
	public void deleteMapById(Integer Id);	
}

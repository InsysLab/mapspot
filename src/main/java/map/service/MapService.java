package map.service;

import java.util.List;

import map.domain.Map;

public interface MapService {
	public List<Map> getAll();
	
	public Map save(Map d);
	
	public Map findMap(Integer Id);
	
	public void deleteMapById(Integer Id);	
	
	public List<Map> findMapByUserId(Integer userId);
}

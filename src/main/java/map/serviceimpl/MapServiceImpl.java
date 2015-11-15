package map.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import map.service.MapService;
import map.domain.Map;
import map.repository.MapRepository;

@Service
@Transactional
public class MapServiceImpl implements MapService{
	
	@Autowired
	MapRepository mapRepository;
	
	public List<Map> getAll(){
		return (List<Map>) mapRepository.findAll();
	}
	
	public Map save(Map map){
		return mapRepository.save(map);
	}
	
	public Map findMap(Integer Id){
		return mapRepository.findOne(Id);
	}
	
	public void deleteMapById(Integer Id){
		Map map = mapRepository.findOne(Id);
		mapRepository.delete(map);
	}
}

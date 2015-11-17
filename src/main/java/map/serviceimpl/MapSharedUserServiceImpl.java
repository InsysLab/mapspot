package map.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import map.domain.MapSharedUser;
import map.repository.MapSharedUserRepository;
import map.service.MapSharedUserService;

@Service
@Transactional
public class MapSharedUserServiceImpl implements MapSharedUserService {
	
	@Autowired
	MapSharedUserRepository mapSharedUserRepository;	
	
	public void save(MapSharedUser u){
		mapSharedUserRepository.save(u);
	}
	
	public List<MapSharedUser> findMapSharedUsersByUserId(Integer userId){
		return mapSharedUserRepository.findMapSharedUsersByUserId(userId);
	}	
}

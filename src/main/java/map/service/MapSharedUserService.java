package map.service;

import java.util.List;
import map.domain.MapSharedUser;

public interface MapSharedUserService {
	
	public void save(MapSharedUser u);
	
	public List<MapSharedUser> findMapSharedUsersByUserId(Integer userId);
	
}

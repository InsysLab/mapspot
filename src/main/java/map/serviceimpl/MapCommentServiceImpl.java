package map.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import map.domain.Comment;
import map.service.MapCommentService;
import map.repository.MapCommentRepository;

@Service
@Transactional
public class MapCommentServiceImpl implements MapCommentService{
	
	@Autowired
	MapCommentRepository mapCommentRepository;
	
	public Comment save(Comment comment){
		return mapCommentRepository.save(comment);
	}
	
	public List<Comment> findCommentsByMapId(Integer mapId){
		return mapCommentRepository.findAllByMapId(mapId);
	}	
	
}

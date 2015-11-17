package map.service;

import java.util.List;
import map.domain.Comment;

public interface MapCommentService {
	
	public Comment save(Comment comment);
	
	public List<Comment> findCommentsByMapId(Integer mapId);
}

package map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import map.domain.Comment;
import map.domain.MapSpot;

@Repository
public interface MapCommentRepository extends CrudRepository<Comment, Integer>{

	@Query("SELECT c FROM Comment c WHERE c.map.mapId = :mapId")
	List<Comment> findAllByMapId(@Param(value = "mapId") Integer mapId);
	
}

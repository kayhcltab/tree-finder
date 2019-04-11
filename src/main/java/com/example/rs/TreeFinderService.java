package com.example.rs;

import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.TreeFinderDao;
import com.example.model.Point;

/**
 * This is the REST end-point to get get list of tree names and their count with
 * the specified radius from the specified starting point(x,y coordinates)
 * 
 * @author KP
 *
 */
@Component
@Path("/trees")
public class TreeFinderService {
	@Autowired
	private TreeFinderDao treeDao;

	/**
	 * This operation fetches list of tree names and their count with the specified
	 * radius from the specified starting point(x,y coordinates)
	 * 
	 * @param point  holds the x,y coordinates of tree
	 * @param radius the radius within which trees to be searched
	 * @return a {@link Map<String, Long>} of tree name and count
	 */
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Map<String, Long> getTrees(@BeanParam Point point, @QueryParam("radius") Double radius) {
		return treeDao.getTrees(point, radius);
	}
}

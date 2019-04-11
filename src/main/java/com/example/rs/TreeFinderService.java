package com.example.rs;

import java.util.List;

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
import com.example.model.Tree;

@Component
@Path("/trees")
public class TreeFinderService {
	@Autowired
    private TreeFinderDao treeDao;
	@GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tree> getTrees(@BeanParam Point point, @QueryParam("radius") long radius) {
    	return treeDao.getTrees(point, radius);
    }
}

package com.example.dao;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.client.TreeRetrievalClient;
import com.example.model.Point;
import com.example.model.Tree;

/**
 * This Class define the Data Access layer to get list of tree names and their
 * count with the specified radius from the specified starting point(x,y
 * coordinates)
 * 
 * @author KP
 *
 */
@Component
public class TreeFinderDao {
	private List<Tree> trees;

	@Autowired
	private TreeRetrievalClient treeClient;

	/**
	 * This method fetches list of tree names and their count with the specified
	 * radius from the specified starting point(x,y coordinates)
	 * 
	 * @param point  holds the x,y coordinates of tree
	 * @param radius the radius within which trees to be searched
	 * @return a {@link Map<String, Long>} of tree name and count
	 */
	public Map<String, Long> getTrees(Point point, double radius) {
		if (null == trees) {
			trees = treeClient.getTreeData();
		}
		return trees.stream().filter(tree -> {
			return ((Math.pow(tree.getX_sp() - point.getX_coordinate(), 2)
					+ Math.pow(tree.getY_sp() - point.getY_coordinate(), 2)) <= Math.pow(radius * 3.28084d, 2));
		}).map(Tree::getSpc_common).filter(Objects::nonNull)
				.collect(Collectors.groupingBy(spc_common -> spc_common, Collectors.counting()));
	}
}

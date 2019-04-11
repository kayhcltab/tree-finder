package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.client.TreeRetrievalClient;
import com.example.model.Point;
import com.example.model.Tree;

@Component
public class TreeFinderDao {
	private List<Tree> trees;
	@Autowired
	private TreeRetrievalClient treeClient;

	public List<Tree> getTrees(Point point, double radius) {
		List<Tree> foundTrees = new ArrayList<>();
		if (null == trees) {
			trees = treeClient.getTreeData();
		}
		for (Tree tree : trees) {
			if ((Math.pow(tree.getX_sp() - point.getX_coordinate(), 2)
					+ Math.pow(tree.getY_sp() - point.getY_coordinate(), 2)) <= radius * 3.28084d) {
				foundTrees.add(tree);
			}
		}
		return foundTrees;
	}
}

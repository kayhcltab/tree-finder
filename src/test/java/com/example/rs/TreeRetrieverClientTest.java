package com.example.rs;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.client.TreeRetrievalClient;
import com.example.model.Tree;
import com.example.util.TreeRetrieverFeignBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(JUnit4.class)
public class TreeRetrieverClientTest {
	private TreeRetrievalClient treeClient;

	@Before
	public void setup() {
		TreeRetrieverFeignBuilder feignClientBuilder = new TreeRetrieverFeignBuilder();
		treeClient = feignClientBuilder.getTreeClient();
	}

	@Test
	public void givenTreeClient_shouldRunSuccessfully() throws Exception {
		Double radius = 1000000.00d;
		List<Tree> trees = treeClient.getTreeData();
		for (Tree tree : trees) {
			if ((Math.pow(tree.getX_sp() - 1027431.148d, 2) + Math.pow(tree.getY_sp() - 202756.7687d, 2)) <= radius) {
				System.out.println(tree.getSpc_common());
			}
		}
	}
}

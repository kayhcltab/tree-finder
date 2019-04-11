package com.example.client;

import java.util.List;

import com.example.model.Tree;

import feign.RequestLine;

/**
 * This feign client fetch the tree data from external service
 * 
 * @author KP
 *
 */
public interface TreeRetrievalClient {
	/**
	 * Fetches list of trees from external url
	 * 
	 * @return {@link List<Tree>}
	 */
	@RequestLine("GET /")
	List<Tree> getTreeData();
}

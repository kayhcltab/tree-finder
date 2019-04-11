package com.example.client;

import java.util.List;

import com.example.model.Tree;

import feign.RequestLine;

public interface TreeRetrievalClient {
	@RequestLine("GET /")
	List<Tree> getTreeData();
}

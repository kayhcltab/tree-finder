package com.example.model;

import javax.ws.rs.QueryParam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
	@QueryParam("x_coordinate") 
	private double x_coordinate;
	@QueryParam("y_coordinate") 
	private double y_coordinate;
}

package com.solution.constants;

import java.io.File;

public interface IAutoConst {

	// URI
	public static final String BASE_URI = "http://dummy.restapiexample.com";

	// EndPoint
	public static final String CREATE_EMPLOYEE = "/api/v1/create";

	public static final String GET_EMPLOYEE = "/api/v1/employee/";

	public static final String DELETE_EMPLOYEE = "/api/v1/delete/";

	// HTTP status codes
	public static final String SUCCESS_CODE = "200";

	// Project paths
	public final String PROJECT_PATH = System.getProperty("user.dir");

	public final static String APK = PROJECT_PATH + File.separator + "apk" + File.separator + "flipkart.apk";

}
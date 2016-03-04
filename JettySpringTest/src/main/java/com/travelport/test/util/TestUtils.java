package com.travelport.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public class TestUtils {

	public static String extractRawResponse(HttpResponse response) throws IllegalStateException, IOException {
		  InputStream is = response.getEntity().getContent();
		  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
		  StringBuilder str = new StringBuilder();

		  String line = null;
		  try {
		    while ((line = bufferedReader.readLine()) != null) {
		      str.append(line + "\n");
		    }
		  } catch (IOException e) {
		    throw new RuntimeException(e);
		  } finally {
		    try {
		      is.close();
		    } catch (IOException e) {
		    }
		  }
		  return str.toString();
		}

	
}

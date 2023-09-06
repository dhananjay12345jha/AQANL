package com.auto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import com.auto.pages.HomePage;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import io.restassured.response.Response;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONObject.*;
import org.slf4j.LoggerFactory;

public class Util {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Util.class);

	public void responseIsCompliant(String fileName, JSONObject response) throws IOException, ProcessingException {
		File file = new File(URLDecoder.decode(System.getProperty("user.dir") + "/src/test/resources/schema/response/"+fileName+".json", "UTF-8"));
		JsonNode expectedSchema = JsonLoader.fromFile(file);

		JsonNode jsonResponse = JsonLoader.fromString(response.toString());
		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		JsonValidator validator = factory.getValidator();
		ProcessingReport report = validator.validate(expectedSchema, jsonResponse, true);

		StringBuilder errorMessage = new StringBuilder("Error in Json Schema Validation: ");
		if (!report.isSuccess()) {
			for (ProcessingMessage processingMessage : report) {
				if (processingMessage.getLogLevel() == LogLevel.ERROR || processingMessage.getLogLevel() == LogLevel.FATAL) {
					//LOG.error("Error in Json Schema Validation" + processingMessage);
					errorMessage.append(processingMessage);
				}
			}
		}
		assertThat(report.isSuccess())
				.withFailMessage(errorMessage.toString())
				.isTrue();
	}

	public JSONObject convertStringToListObj(String targetString)
	{
		JSONObject jsonObject = null;

		try {
			jsonObject = new JSONObject(targetString);
		}catch (JSONException err){
			LOG.error("Error: ", err);
		}

		return jsonObject;
	}
}

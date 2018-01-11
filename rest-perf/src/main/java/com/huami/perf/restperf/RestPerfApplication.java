package com.huami.perf.restperf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@SpringBootApplication
@RestController
public class RestPerfApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPerfApplication.class, args);
	}

	@PostMapping(path = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
	public RestResponse rest(@RequestBody RestRequest request) throws InterruptedException {
		RestResponse response = new RestResponse();
		Thread.sleep(1000); //comment this line if you are testing the raw REST perf
        response.setValue("hello" + request.getValue());
        return response;
	}

	public static class RestRequest {
        @JsonProperty
        private String value;

		public String getValue() {
			return value;
		}

        public void setValue(String value) {
            this.value = value;
        }
    }

	public static class RestResponse {
	    @JsonProperty
		private String value;

		public String getValue() {
			return value;
		}

        public void setValue(String value) {
            this.value = value;
        }
    }
}

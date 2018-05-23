package gr.com.arounder.cloud;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FooConfiguration {
	@Bean
	public Request.Options options()
	{
		return new Request.Options(1000, 6000);
	}
}
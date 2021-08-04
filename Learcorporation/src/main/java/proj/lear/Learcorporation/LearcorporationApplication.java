package proj.lear.Learcorporation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import proj.lear.Learcorporation.DAO.ILicenceDAO;
import proj.lear.Learcorporation.DAO.ISoftwareDAO;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class LearcorporationApplication implements CommandLineRunner{
	
	@Autowired
	private ILicenceDAO licencedao;

	@Autowired
	private ISoftwareDAO sotwaredao;
	
	public static void main(String[] args) {
		SpringApplication.run(LearcorporationApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("proj.lear.Learcorporation.Controllers"))
				.build()
				.apiInfo(apiDetails());
	}
	
	
	private ApiInfo apiDetails() {
	    return new ApiInfoBuilder()
	            .title( "application de gestion de Licences et softwares" )
	            .description( "Toutes les demandes auxquelles le serveur répondra." )
	            .version( "1.0.0" )
	            .build();
	}
	
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Software S = sotwaredao.AjouterSoftware(new Software("soft_ref", "soft_manif", "soft_suppl", "soft_familly", "soft_version","soft_Desc","hgcgh"));
		//Licence L = licencedao.AjouterLicence(new Licence("cvghjhccvh", "0", "khghjkbhhxxxx", "0", "xxxyy",
				//"cc", "cc", S));
		
	}
	


	
}

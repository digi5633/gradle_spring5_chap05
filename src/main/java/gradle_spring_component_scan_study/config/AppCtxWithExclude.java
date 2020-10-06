package gradle_spring_component_scan_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import gradle_spring_component_scan_study.spring.MemberPrinter;
import gradle_spring_component_scan_study.spring.MemberSummaryPrinter;
import gradle_spring_component_scan_study.spring.VersionPrinter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*@ComponentScan(basePackages = { "spring" },
				excludeFilters = @Filter(type = FilterType.REGEX,
										pattern = "spring\\..*Dao"))*/
@ComponentScan(basePackages = { "spring" },
				excludeFilters = @Filter(type = FilterType.ASPECTJ,
										pattern = "spring.*Dao"))
public class AppCtxWithExclude {

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}

}

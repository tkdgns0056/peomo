package com.hoon.peomo.config;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"com.hoon.peomo.mapper"}
			,sqlSessionFactoryRef = "defaultSqlSessionFactory"
			,annotationClass = Mapper.class
)
public class DefaultSqlConfig {
	
	@Primary
	@Bean(name = "defaultDataSource")
	public DataSource defaultDataSource() {
		return buildDefaultDataSource();
	}
	
	@Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource buildDefaultDataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		return hikariDataSource;
    }
	
	public TransactionInterceptor txAdvice(DataSourceTransactionManager transactionManager, int transactionDefinition) {

		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		Properties transactionAttributes = new Properties();

		// 롤백 룰 설정
		List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
		rollbackRules.add(new RollbackRuleAttribute(Exception.class));

		// 읽기전용 트랜잭션 속성 설정
		DefaultTransactionAttribute readOnlyTransactionAttribute = new DefaultTransactionAttribute();
		readOnlyTransactionAttribute.setReadOnly(true);

		String readOnlyTransactionAttributesDefinition = readOnlyTransactionAttribute.toString();

		// 기본 트랜잭션 속성 설정
		RuleBasedTransactionAttribute writeTransactionAttribute = new RuleBasedTransactionAttribute(transactionDefinition, rollbackRules);

		String writeTransactionAttributesDefinition = writeTransactionAttribute.toString();

		transactionAttributes.setProperty("insert*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("update*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("delete*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("merge*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("save*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("create*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("drop*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("cancel*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("proc*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("apply*", writeTransactionAttributesDefinition);
		transactionAttributes.setProperty("send*", writeTransactionAttributesDefinition);

		transactionInterceptor.setTransactionAttributes(transactionAttributes);
		transactionInterceptor.setTransactionManager(transactionManager);

		return transactionInterceptor;
	}
	
	@Primary
	@Bean(name = "defaultTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("defaultDataSource") final DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Primary
	@Bean(name = "defaultAdvisor")
	public Advisor txAdviceAdvisor(@Qualifier("defaultTransactionManager") final DataSourceTransactionManager transactionManager) {

		TransactionInterceptor transactionInterceptor = txAdvice(transactionManager, TransactionDefinition.PROPAGATION_REQUIRED);

		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.hoon.peomo.service.*Impl.*(..))");

		return new DefaultPointcutAdvisor(pointcut, transactionInterceptor);
	}

	@Primary
	@Bean(name = "defaultSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("defaultDataSource") final DataSource dataSource,
			final ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/**/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}
	
}

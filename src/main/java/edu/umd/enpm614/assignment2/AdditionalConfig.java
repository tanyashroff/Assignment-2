package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.interfaces.*;
import edu.umd.enpm614.assignment2.services.*;
import edu.umd.enpm614.assignment2.application.WebApplication;
import edu.umd.enpm614.assignment2.services.MiddlewareJBoss;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_2_ENV;

@Profile(TASK_2_ENV)
@Configuration
public class AdditionalConfig {
    public static final String INJECT_FrontendGWT = "edu.umd.enpm614.frontend.gwt";
    public static final String INJECT_MiddlewareJBoss = "edu.umd.enpm614.middleware.jboss";
    public static final String INJECT_PersistenceOracle = "edu.umd.enpm614.persistence.oracle";
    public static final String INJECT_AuthenticationTSL = "edu.umd.enpm614.authentication.tsl";
    public static final String INJECT_FileSystemNFS = "edu.umd.enpm614.filesystem.nfs";
    public static final String INJECT_ConnectionJDBC = "edu.umd.enpm614.connection.jdbc";

    private FrontendGWT frontendGWT;
    @Bean(name = INJECT_FrontendGWT)
    public Frontend getFrontend() {
        return frontendGWT;
    }

    private MiddlewareJBoss middlewareJBoss;
    @Bean(name = INJECT_MiddlewareJBoss)
    public Middleware getMiddleware() {
        return middlewareJBoss;
    }

    private PersistanceOracle persistanceOracle;
    @Bean(name = INJECT_PersistenceOracle)
    public Persistance getPersistence() {
        return persistanceOracle;
    }

    private AuthenticationTSL authenticationTSL;
    @Bean(name = INJECT_AuthenticationTSL)
    public Authentication getAuthentication() {
        return authenticationTSL;
    }

    private FileSystemNFS fileSystemNFS;
    @Bean(name = INJECT_FileSystemNFS)
    public FileSystem getFilesystem() {
        return fileSystemNFS;
    }

    private ConnectionJDBC connectionJDBC;
    @Bean(name = INJECT_ConnectionJDBC)
    public Connection getConnection() {
        return connectionJDBC;
    }
}

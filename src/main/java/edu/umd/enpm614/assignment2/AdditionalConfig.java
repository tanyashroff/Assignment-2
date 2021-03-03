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


    @Bean(name = INJECT_FrontendGWT)
    public Frontend getFrontend(FrontendGWT frontendGWT) {
        return frontendGWT;
    }

    @Bean(name = INJECT_MiddlewareJBoss)
    public Middleware getMiddleware(MiddlewareJBoss middlewareJBoss) {
        return middlewareJBoss;
    }

    @Bean(name = INJECT_PersistenceOracle)
    public Persistance getPersistence(PersistanceOracle persistanceOracle) {
        return persistanceOracle;
    }

    @Bean(name = INJECT_AuthenticationTSL)
    public Authentication getAuthentication(AuthenticationTSL authenticationTSL) {
        return authenticationTSL;
    }

    @Bean(name = INJECT_FileSystemNFS)
    public FileSystem getFilesystem(FileSystemNFS fileSystemNFS) {
        return fileSystemNFS;
    }

    @Bean(name = INJECT_ConnectionJDBC)
    public Connection getConnection(ConnectionJDBC connectionJDBC) {
        return connectionJDBC;
    }
}

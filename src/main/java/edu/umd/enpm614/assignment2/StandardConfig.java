package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.interfaces.*;
import edu.umd.enpm614.assignment2.services.FrontendHTML;
import edu.umd.enpm614.assignment2.services.MiddlewareTomcat;
import edu.umd.enpm614.assignment2.services.AuthenticationSSL;
import edu.umd.enpm614.assignment2.services.PersistanceMySQL;
import edu.umd.enpm614.assignment2.services.FileSystemNTFS;
import edu.umd.enpm614.assignment2.services.ConnectionPooled;
import edu.umd.enpm614.assignment2.application.WebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_1_ENV;

@Profile(TASK_1_ENV)
@Configuration
public class StandardConfig {
    public static final String INJECT_FrontendHTML = "edu.umd.enpm614.frontend.html";
    public static final String INJECT_MiddlewareTomcat = "edu.umd.enpm614.middleware.tomcat";
    public static final String INJECT_PersistenceMySQL = "edu.umd.enpm614.persistence.mysql";
    public static final String INJECT_AuthenticationSSL = "edu.umd.enpm614.authentication.ssl";
    public static final String INJECT_FileSystemNTFS = "edu.umd.enpm614.filesystem.ntfs";
    public static final String INJECT_ConnectionPooled = "edu.umd.enpm614.connection.pooled";


    @Primary
    @Bean(name = INJECT_FrontendHTML)
    public Frontend getFrontend(FrontendHTML frontendHTML) {
        return frontendHTML ;
    }

    @Primary
    @Bean(name = INJECT_MiddlewareTomcat)
    public Middleware getMiddleware(MiddlewareTomcat middlewareTomcat) {
        return middlewareTomcat;
    }

    @Primary
    @Bean(name = INJECT_PersistenceMySQL)
    public Persistance getPersistence(PersistanceMySQL persistanceMySQL) {
        return persistanceMySQL;
    }

    @Primary
    @Bean(name = INJECT_AuthenticationSSL)
    public Authentication getAuthentication(Authentication authenticationSSL) {
        return authenticationSSL;
    }

    @Primary
    @Bean(name = INJECT_FileSystemNTFS)
    public FileSystem getFilesystem(FileSystemNTFS fileSystemNTFS) {
        return fileSystemNTFS;
    }

    @Primary
    @Bean(name = INJECT_ConnectionPooled)
    public Connection getConnection(ConnectionPooled connectionPooled) {
        return connectionPooled;
    }
}

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by eduardo on 26/12/14.
 */
public class Global extends GlobalSettings
{

    /**
     * The name of the persistence unit we will be using.
     */
    static final String DEFAULT_PERSISTENCE_UNIT = "default";

    /**
     * Declare the application context to be used - a Java annotation based application context requiring no XML.
     */
    final private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    @Override
    public void onStart (Application application)
    {

        super.onStart(application);
        // AnnotationConfigApplicationContext can only be refreshed once, but we do it here even though this method
        // can be called multiple times. The reason for doing during startup is so that the Play configuration is
        // entirely available to this application context.
        ctx.register(SpringDataJpaConfiguration.class);
        ctx.scan("controllers", "models", "repositories", "security", "daos");
        ctx.refresh();
        // This will construct the beans and call any construction lifecycle methods e.g. @PostConstruct
        ctx.start();
    }

    @Override
    public void onStop (Application application)
    {
        super.onStop(application);

    }

    @Override
    public <T> T getControllerInstance (Class<T> aClass) throws Exception
    {
        return ctx.getBean(aClass);
    }


    @Override
    public Action<?> onRequest (Http.Request request, java.lang.reflect.Method actionMethod)
    {
        return new Action.Simple()
        {

            @Override
            public F.Promise<Result> call (Http.Context ctx) throws java.lang.Throwable
            {

                ctx.response().setHeader("Access-Control-Allow-Origin", "*");
                ctx.response().setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
                ctx.response().setHeader("Access-Control-Allow-Headers",
                        "accept, origin, Content-type, x-json,x-prototype-version, x-requested-with,useXDomain, PLAY_SESSION,X-AUTH-TOKEN");
                Logger.debug("Calling :" + ctx);
                return this.delegate.call(ctx);
            }
        };
    }

    /**
     * This configuration establishes Spring Data concerns including those of JPA.
     */
    @Configuration
    @EnableJpaRepositories("repositories")
    public static class SpringDataJpaConfiguration
    {

        @Bean
        public EntityManagerFactory entityManagerFactory ()
        {
            return Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
        }

        @Bean
        public HibernateExceptionTranslator hibernateExceptionTranslator ()
        {
            return new HibernateExceptionTranslator();
        }

        @Bean
        public JpaTransactionManager transactionManager ()
        {
            return new JpaTransactionManager();
        }
    }
}

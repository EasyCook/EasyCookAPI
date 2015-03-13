package security;

import play.mvc.With;

import java.lang.annotation.*;

@With(TokenAuthAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@Inherited
@Documented
public @interface TokenAuth
{

}
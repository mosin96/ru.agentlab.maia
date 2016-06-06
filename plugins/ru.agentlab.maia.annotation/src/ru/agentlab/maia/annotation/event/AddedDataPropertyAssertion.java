package ru.agentlab.maia.annotation.event;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Dmitriy Shishkin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AddedDataPropertyAssertion {

	String subject();

	String property();

	String value();

	String language() default "";

	String type() default "rdf:PlainLiteral";

}

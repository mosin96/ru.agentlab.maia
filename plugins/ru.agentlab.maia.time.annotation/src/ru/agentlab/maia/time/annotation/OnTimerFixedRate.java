package ru.agentlab.maia.time.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import ru.agentlab.maia.converter.PlanEventFilter;
import ru.agentlab.maia.converter.PlanExtra;
import ru.agentlab.maia.time.TimerEvent;
import ru.agentlab.maia.time.annotation.converter.OnTimerFixedRateExtraPlansConverter;
import ru.agentlab.maia.time.annotation.converter.OnTimerXXXEventMatcherConverter;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@PlanEventFilter(converter = OnTimerXXXEventMatcherConverter.class, eventType = TimerEvent.class)
@PlanExtra(converter = OnTimerFixedRateExtraPlansConverter.class)
public @interface OnTimerFixedRate {

	long value();

	long delay() default 0;

	TimeUnit unit() default TimeUnit.MILLISECONDS;
	
}

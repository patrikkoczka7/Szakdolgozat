package szakdolgozat.transformation.rules.priority1;

import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory.EventDrivenTransformationRuleBuilder;

public interface RuleSet {
	
	EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory();
	
	List<EventDrivenTransformationRule<?, ?>> createRules(final ViatraQueryEngine engine);


    default <A extends IPatternMatch, B extends ViatraQueryMatcher<A>> EventDrivenTransformationRuleBuilder<A, B> createRule(
            final IQuerySpecification<B> in) {
        return ruleFactory.createRule(in);
    }

}

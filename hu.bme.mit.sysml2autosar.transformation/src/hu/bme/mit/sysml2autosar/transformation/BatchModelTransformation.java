package hu.bme.mit.sysml2autosar.transformation;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;

public class BatchModelTransformation {

	/* Transformation-related extensions */
	private BatchTransformation transformation;
	private BatchTransformationStatements statements;

	/* Transformation rule-related extensions */
	private BatchTransformationRuleFactory batchTransformationRuleFactory = new BatchTransformationRuleFactory();
	private IModelManipulations manipulation;

	protected ViatraQueryEngine engine;
	protected ResourceSet umlResourceSet;
	// protected BatchTransformationRule<?,?> exampleRule

	public BatchModelTransformation(ResourceSet umlResourceSet) {
		this.umlResourceSet = umlResourceSet;
		// Create EMF scope and EMF IncQuery engine based on the resource
		var scope = new EMFScope(umlResourceSet);
		engine = ViatraQueryEngine.on(scope);

		createTransformation();

	}

	public void execute() {
//      Fire the defined rules here
//      exampleRule.fireAllCurrent
	}

	private void createTransformation() {
		// Create VIATRA model manipulations
		this.manipulation = new SimpleModelManipulations(engine);
		// Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build();
		// Initialize batch transformation statements
		statements = transformation.getTransformationStatements();
	}

//  private def getExampleRule() {
//      if(exampleRule == null){
//          exampleRule = createRule.name("ExampleRule").precondition(ExampleMatcher.querySpecification).action [
//              Do Rule Actions here
//          ].build
//      }
//      return exampleRule
//  }

//    void dispose() {
//        if (transformation != null) {
//           // transformation.ruleEngine.dispose();
//        }
//        transformation = null;
//        return;
//    }
}


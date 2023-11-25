package hu.bme.mit.sysml2autosar.transformation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;

import autosar40.autosartoplevelstructure.AUTOSAR;
import autosar40.autosartoplevelstructure.AutosartoplevelstructureFactory;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ARPackage;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ArpackageFactory;
import autosar40.swcomponent.portinterface.ClientServerInterface;
import autosar40.swcomponent.portinterface.PortinterfaceFactory;
import autosar40.swcomponent.portinterface.SenderReceiverInterface;
import autosar40.swcomponent.components.AtomicSwComponentType;
import autosar40.swcomponent.components.ComponentsFactory;
import autosar40.swcomponent.composition.CompositionFactory;
import autosar40.swcomponent.composition.CompositionSwComponentType;
import hu.bme.mit.sysml2autosar.queries.AtomicSwComponentTypes;
import hu.bme.mit.sysml2autosar.queries.ClientServerInterfaceType;
import hu.bme.mit.sysml2autosar.queries.CompositionSwComponentTypes;
import hu.bme.mit.sysml2autosar.queries.SenderReceiverInterfaceType;

public class BatchModelTransformation {

	/* Transformation-related extensions */
	private BatchTransformation transformation;
	private BatchTransformationStatements statements;

	/* Transformation rule-related extensions */
	private BatchTransformationRuleFactory batchTransformationRuleFactory = new BatchTransformationRuleFactory();
	private IModelManipulations manipulation;
	
	private final ARPackage arRoot = ArpackageFactory.eINSTANCE.createARPackage(); 
	private final ARPackage applicationDataType = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage swComponents = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage portInterfaces = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage swComponentTypes = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage atomicSwComponentTypes = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage compositionSwComponentTypes = ArpackageFactory.eINSTANCE.createARPackage();

	protected ViatraQueryEngine engine;
	protected ResourceSet umlResourceSet;
	protected Resource autosarResource;
	
	protected BatchTransformationRule<?, ?> clientServerInterfaceRule = batchTransformationRuleFactory.createRule(ClientServerInterfaceType.instance()).name("ClientServerInterfaceRule").action(match -> {
		Class csi = match.getUmlClass();
		String csi_name = csi.getName();
		ClientServerInterface autosarInterface = PortinterfaceFactory.eINSTANCE.createClientServerInterface();
		autosarInterface.setShortName(csi_name);
		portInterfaces.getElements().add(autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> senderReceiverInterfaceRule = batchTransformationRuleFactory.createRule(SenderReceiverInterfaceType.instance()).name("SenderReceiverInterfaceRule").action(match -> {
		Class sri = match.getUmlClass();
		String sri_name = sri.getName();
		SenderReceiverInterface autosarInterface = PortinterfaceFactory.eINSTANCE.createSenderReceiverInterface();
		autosarInterface.setShortName(sri_name);
		portInterfaces.getElements().add(autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> atomicSwComponentTypesRule = batchTransformationRuleFactory.createRule(AtomicSwComponentTypes.instance()).name("AtomicSwComponentTypesRule").action(match -> {
		Class aswct = match.getUmlClass();
		String aswct_name = aswct.getName();
		AtomicSwComponentType autosarAswct = ComponentsFactory.eINSTANCE.createApplicationSwComponentType();
		autosarAswct.setShortName(aswct_name);
		portInterfaces.getElements().add(autosarAswct);
	}).build();
	
	protected BatchTransformationRule<?, ?> compositionSwComponentTypesRule = batchTransformationRuleFactory.createRule(CompositionSwComponentTypes.instance()).name("CompositionSwComponentTypesRule").action(match -> {
		Class cswct = match.getUmlClass();
		String cswct_name = cswct.getName();
		CompositionSwComponentType autosarCswct = CompositionFactory.eINSTANCE.createCompositionSwComponentType();
		autosarCswct.setShortName(cswct_name);
		portInterfaces.getElements().add(autosarCswct);
	}).build();

	public BatchModelTransformation(ResourceSet umlResourceSet, Resource autosarResource) {
		this.umlResourceSet = umlResourceSet;
		this.autosarResource = autosarResource;
		// Create EMF scope and EMF IncQuery engine based on the resource
		var scope = new EMFScope(umlResourceSet);
		engine = ViatraQueryEngine.on(scope);
		
		createTransformation();

	}

	public void execute() {
//      Fire the defined rules here
//      exampleRule.fireAllCurrent
		AUTOSAR autosar = AutosartoplevelstructureFactory.eINSTANCE.createAUTOSAR();
		autosarResource.getContents().add(autosar);
		arRoot.setShortName("ARRoot");
		autosar.getArPackages().add(arRoot);
		applicationDataType.setShortName("ApplicationDataType");
		arRoot.getArPackages().add(applicationDataType);
		swComponents.setShortName("SwComponents");
		arRoot.getArPackages().add(swComponents);
		portInterfaces.setShortName("PortInterfaces");
		swComponents.getArPackages().add(portInterfaces);
		swComponentTypes.setShortName("SwComponentTypes");
		swComponents.getArPackages().add(swComponentTypes);
		atomicSwComponentTypes.setShortName("AtomicSwComponentTypes");
		swComponentTypes.getArPackages().add(atomicSwComponentTypes);
		compositionSwComponentTypes	.setShortName("CompositionSwComponentTypes");	
		swComponentTypes.getArPackages().add(compositionSwComponentTypes);
		statements.fireAllCurrent(clientServerInterfaceRule);
		statements.fireAllCurrent(senderReceiverInterfaceRule);
		statements.fireAllCurrent(atomicSwComponentTypesRule);
		statements.fireAllCurrent(compositionSwComponentTypesRule);
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


package hu.bme.mit.sysml2autosar.transformation;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
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
import autosar40.genericstructure.generaltemplateclasses.arobject.ARObject;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ARPackage;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ArpackageFactory;
import autosar40.genericstructure.generaltemplateclasses.arpackage.PackageableElement;
import autosar40.swcomponent.components.AtomicSwComponentType;
import autosar40.swcomponent.components.ComponentsFactory;
import autosar40.swcomponent.composition.AssemblySwConnector;
import autosar40.swcomponent.composition.CompositionFactory;
import autosar40.swcomponent.composition.CompositionSwComponentType;
import autosar40.swcomponent.composition.DelegationSwConnector;
import autosar40.swcomponent.composition.SwComponentPrototype;
import autosar40.swcomponent.datatype.datatypes.ApplicationPrimitiveDataType;
import autosar40.swcomponent.datatype.datatypes.DatatypesFactory;
import autosar40.swcomponent.portinterface.ClientServerInterface;
import autosar40.swcomponent.portinterface.PortInterface;
import autosar40.swcomponent.portinterface.PortinterfaceFactory;
import autosar40.swcomponent.portinterface.SenderReceiverInterface;
import autosar40.swcomponent.portinterface.ClientServerOperation;
import autosar40.swcomponent.datatype.dataprototypes.VariableDataPrototype;
import hu.bme.mit.sysml2autosar.queries.ApplicationDataType;
import hu.bme.mit.sysml2autosar.queries.AssemblySwConnectors;
import hu.bme.mit.sysml2autosar.queries.AtomicSwComponentTypes;
import hu.bme.mit.sysml2autosar.queries.ClientServerInterfaceType;
import hu.bme.mit.sysml2autosar.queries.CompositionSwComponentTypes;
import hu.bme.mit.sysml2autosar.queries.CsiOperation;
import hu.bme.mit.sysml2autosar.queries.DelegateSwConnectors;
import hu.bme.mit.sysml2autosar.queries.ProvidePortAswct;
import hu.bme.mit.sysml2autosar.queries.ProvidePortCswct;
import hu.bme.mit.sysml2autosar.queries.ReceivePortAswct;
import hu.bme.mit.sysml2autosar.queries.ReceivePortCswct;
import hu.bme.mit.sysml2autosar.queries.SenderReceiverInterfaceType;
import hu.bme.mit.sysml2autosar.queries.SriVariableDataPrototype;
import hu.bme.mit.sysml2autosar.queries.SwComponentPrototypes;

public class BatchModelTransformation {
	
	private HashMap<Element, PortInterface> arxml_interfaces = new HashMap<Element, PortInterface>();
	private HashMap<Element, AtomicSwComponentType> arxml_aswcts = new HashMap<Element, AtomicSwComponentType>();
	private HashMap<Element, CompositionSwComponentType> arxml_cswcts = new HashMap<Element, CompositionSwComponentType>();
	private HashMap<Element, AssemblySwConnector> arxml_aswconns = new HashMap<Element, AssemblySwConnector>();
	private HashMap<Element, DelegationSwConnector> arxml_dswconns = new HashMap<Element, DelegationSwConnector>();

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
	
	protected BatchTransformationRule<?, ?> applicationDataTypesRule = batchTransformationRuleFactory.createRule(ApplicationDataType.instance()).name("ApplicationDataTypesRule").action(match -> {
		DataType apdt = match.getUmlDataType();
		String apdt_name = apdt.getName();
		ApplicationPrimitiveDataType autosarApdt = DatatypesFactory.eINSTANCE.createApplicationPrimitiveDataType();
		autosarApdt.setShortName(apdt_name);
		applicationDataType.getElements().add(autosarApdt);
	}).build();
	
	protected BatchTransformationRule<?, ?> clientServerInterfaceRule = batchTransformationRuleFactory.createRule(ClientServerInterfaceType.instance()).name("ClientServerInterfaceRule").action(match -> {
		Class csi = match.getUmlClass();
		String csi_name = csi.getName();
		ClientServerInterface autosarInterface = PortinterfaceFactory.eINSTANCE.createClientServerInterface();
		autosarInterface.setShortName(csi_name);
		portInterfaces.getElements().add(autosarInterface);
		arxml_interfaces.put(csi, autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> clientServerOperationRule = batchTransformationRuleFactory.createRule(CsiOperation.instance()).name("ClientServerOperationRule").action(match -> {
//		Class csi = match.getUmlClass();
//		EList<Operation> clientserver = csi.getOwnedOperations();
//		String csio_name = clientserver.get(0).getName();
		ClientServerOperation autosarCSOperation = PortinterfaceFactory.eINSTANCE.createClientServerOperation();
//		autosarCSOperation.setShortName(csio_name);
//		portInterfaces.getElements().add(autosarCSOperation);
	}).build();
	
	protected BatchTransformationRule<?, ?> senderReceiverInterfaceRule = batchTransformationRuleFactory.createRule(SenderReceiverInterfaceType.instance()).name("SenderReceiverInterfaceRule").action(match -> {
		Class sri = match.getUmlClass();
		String sri_name = sri.getName();
		SenderReceiverInterface autosarInterface = PortinterfaceFactory.eINSTANCE.createSenderReceiverInterface();
		autosarInterface.setShortName(sri_name);
		portInterfaces.getElements().add(autosarInterface);
		arxml_interfaces.put(sri, autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> variableDataPrototypeRule = batchTransformationRuleFactory.createRule(SriVariableDataPrototype.instance()).name("VariableDataProtoypeRule").action(match -> {
//		Class sri = match.getUmlClass();
//		String sri_name = sri.getName();
//		VariableDataPrototype autosarInterface = 
//		autosarInterface.setShortName(sri_name);
//		portInterfaces.getElements().add(autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> atomicSwComponentTypesRule = batchTransformationRuleFactory.createRule(AtomicSwComponentTypes.instance()).name("AtomicSwComponentTypesRule").action(match -> {
		Property aswct = match.getUmlProperty();
		String aswct_name = aswct.getName();
		AtomicSwComponentType autosarAswct = ComponentsFactory.eINSTANCE.createApplicationSwComponentType();
		autosarAswct.setShortName(aswct_name);
		atomicSwComponentTypes.getElements().add(autosarAswct);
		arxml_aswcts.put(aswct, autosarAswct);
	}).build();
	
	protected BatchTransformationRule<?, ?> receivePortAswctRule = batchTransformationRuleFactory.createRule(ReceivePortAswct.instance()).name("RPortAswctRule").action(match -> {

	}).build();
	
	protected BatchTransformationRule<?, ?> providePortAswctRule = batchTransformationRuleFactory.createRule(ProvidePortAswct.instance()).name("PPortAswctRule").action(match -> {

	}).build();
	
	protected BatchTransformationRule<?, ?> compositionSwComponentTypesRule = batchTransformationRuleFactory.createRule(CompositionSwComponentTypes.instance()).name("CompositionSwComponentTypesRule").action(match -> {
		Class cswct = match.getUmlClass();
		String cswct_name = cswct.getName();
		CompositionSwComponentType autosarCswct = CompositionFactory.eINSTANCE.createCompositionSwComponentType();
		autosarCswct.setShortName(cswct_name);
		compositionSwComponentTypes.getElements().add(autosarCswct);
		arxml_cswcts.put(cswct, autosarCswct);
	}).build();
	
	protected BatchTransformationRule<?, ?> swComponentPrototypeRule = batchTransformationRuleFactory.createRule(SwComponentPrototypes.instance()).name("SwComponentTypeRule").action(match -> {
//		DataType scp = match.getUmlDataType();
//		String scp_name = apdt.getName();
		SwComponentPrototype autosarScp = CompositionFactory.eINSTANCE.createSwComponentPrototype();
//		autosarScp.setShortName(scp_name);
//		compositionSwComponentTypes.getElements().add(autosarScp);
	}).build();
	
	protected BatchTransformationRule<?, ?> receivePortCswctRule = batchTransformationRuleFactory.createRule(ReceivePortCswct.instance()).name("RPortCswctRule").action(match -> {

	}).build();
	
	protected BatchTransformationRule<?, ?> providePortCswctRule = batchTransformationRuleFactory.createRule(ProvidePortCswct.instance()).name("PPortCswctRule").action(match -> {

	}).build();
	
	protected BatchTransformationRule<?, ?> assemblySwConnectorRule = batchTransformationRuleFactory.createRule(AssemblySwConnectors.instance()).name("ASWConnectorRule").action(match -> {
		arxml_aswconns.put(null, null);
	}).build();
	
	protected BatchTransformationRule<?, ?> delegationSwConnectorRule = batchTransformationRuleFactory.createRule(DelegateSwConnectors.instance()).name("DSWConnectorRule").action(match -> {
		arxml_dswconns.put(null, null);
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
		statements.fireAllCurrent(applicationDataTypesRule);
		statements.fireAllCurrent(clientServerInterfaceRule);
		statements.fireAllCurrent(clientServerOperationRule);
		statements.fireAllCurrent(senderReceiverInterfaceRule);
		statements.fireAllCurrent(variableDataPrototypeRule);
		statements.fireAllCurrent(atomicSwComponentTypesRule);
		statements.fireAllCurrent(receivePortAswctRule);
		statements.fireAllCurrent(providePortAswctRule);
		statements.fireAllCurrent(compositionSwComponentTypesRule);
		statements.fireAllCurrent(swComponentPrototypeRule);
		statements.fireAllCurrent(receivePortCswctRule);
		statements.fireAllCurrent(providePortCswctRule);
		statements.fireAllCurrent(assemblySwConnectorRule);
		statements.fireAllCurrent(delegationSwConnectorRule);
	}

	private void createTransformation() {
		// Create VIATRA model manipulations
		this.manipulation = new SimpleModelManipulations(engine);
		// Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build();
		// Initialize batch transformation statements
		statements = transformation.getTransformationStatements();
	}

//    void dispose() {
//        if (transformation != null) {
//           // transformation.ruleEngine.dispose();
//        }
//        transformation = null;
//        return;
//    }
}


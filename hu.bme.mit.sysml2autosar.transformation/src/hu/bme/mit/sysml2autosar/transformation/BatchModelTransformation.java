package hu.bme.mit.sysml2autosar.transformation;

import java.util.HashMap;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
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
import autosar40.genericstructure.generaltemplateclasses.arpackage.ARPackage;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ArpackageFactory;
import autosar40.swcomponent.components.AtomicSwComponentType;
import autosar40.swcomponent.components.ComponentsFactory;
import autosar40.swcomponent.components.PPortPrototype;
import autosar40.swcomponent.components.RPortPrototype;
import autosar40.swcomponent.composition.AssemblySwConnector;
import autosar40.swcomponent.composition.CompositionFactory;
import autosar40.swcomponent.composition.CompositionSwComponentType;
import autosar40.swcomponent.composition.DelegationSwConnector;
import autosar40.swcomponent.composition.SwComponentPrototype;
import autosar40.swcomponent.datatype.dataprototypes.DataprototypesFactory;
import autosar40.swcomponent.datatype.dataprototypes.VariableDataPrototype;
import autosar40.swcomponent.datatype.datatypes.ApplicationPrimitiveDataType;
import autosar40.swcomponent.datatype.datatypes.DatatypesFactory;
import autosar40.swcomponent.portinterface.ClientServerInterface;
import autosar40.swcomponent.portinterface.ClientServerOperation;
import autosar40.swcomponent.portinterface.PortInterface;
import autosar40.swcomponent.portinterface.PortinterfaceFactory;
import autosar40.swcomponent.portinterface.SenderReceiverInterface;
import autosar40.swcomponent.composition.instancerefs.InstancerefsFactory;
import autosar40.swcomponent.composition.instancerefs.PPortInCompositionInstanceRef;
import autosar40.swcomponent.composition.instancerefs.RPortInCompositionInstanceRef;
import hu.bme.mit.sysml2autosar.queries.ApplicationDataType;
import hu.bme.mit.sysml2autosar.queries.AssemblySwConnectors;
import hu.bme.mit.sysml2autosar.queries.AtomicSwComponentTypes;
import hu.bme.mit.sysml2autosar.queries.ClientServerInterfaceType;
import hu.bme.mit.sysml2autosar.queries.CompositionSwComponentTypes;
import hu.bme.mit.sysml2autosar.queries.CsiOperation;
import hu.bme.mit.sysml2autosar.queries.PDelegateSwConnectors;
import hu.bme.mit.sysml2autosar.queries.PDswConnInstanceRef;
import hu.bme.mit.sysml2autosar.queries.ProvidePortAswct;
import hu.bme.mit.sysml2autosar.queries.ProvidePortCswct;
import hu.bme.mit.sysml2autosar.queries.RDelegateSwConnectors;
import hu.bme.mit.sysml2autosar.queries.RDswConnInstanceRef;
import hu.bme.mit.sysml2autosar.queries.ReceivePortAswct;
import hu.bme.mit.sysml2autosar.queries.ReceivePortCswct;
import hu.bme.mit.sysml2autosar.queries.SenderReceiverInterfaceType;
import hu.bme.mit.sysml2autosar.queries.SriVariableDataPrototype;
import hu.bme.mit.sysml2autosar.queries.SwComponentPrototypes;

public class BatchModelTransformation {
	
	private HashMap<Element, ApplicationPrimitiveDataType> arxml_apdts = new HashMap<Element, ApplicationPrimitiveDataType>();
	private HashMap<Element, PortInterface> arxml_interfaces = new HashMap<Element, PortInterface>();
	private HashMap<Element, AtomicSwComponentType> arxml_aswcts = new HashMap<Element, AtomicSwComponentType>();
	private HashMap<Element, CompositionSwComponentType> arxml_cswcts = new HashMap<Element, CompositionSwComponentType>();
	private HashMap<Element, ClientServerOperation> arxml_cso = new HashMap<Element, ClientServerOperation>();
	private HashMap<Element, VariableDataPrototype> arxml_vdps = new HashMap<Element, VariableDataPrototype>();
	private HashMap<Element, RPortPrototype> arxml_rports = new HashMap<Element, RPortPrototype>();
	private HashMap<Element, PPortPrototype> arxml_pports = new HashMap<Element, PPortPrototype>();
	private HashMap<Element, SwComponentPrototype> arxml_scps = new HashMap<Element, SwComponentPrototype>();
	private HashMap<Element, AssemblySwConnector> arxml_aswconns = new HashMap<Element, AssemblySwConnector>();
	private HashMap<Element, DelegationSwConnector> arxml_dswconns = new HashMap<Element, DelegationSwConnector>();
	
	private Integer scpNum = 1;
	
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
		autosarApdt.setCategory("VALUE");
		applicationDataType.getElements().add(autosarApdt);
		arxml_apdts.put(apdt, autosarApdt);
	}).build();
	
	protected BatchTransformationRule<?, ?> clientServerInterfaceRule = batchTransformationRuleFactory.createRule(ClientServerInterfaceType.instance()).name("ClientServerInterfaceRule").action(match -> {
		Class csi = match.getUmlClass();
		String csi_name = csi.getName();
		ClientServerInterface autosarInterface = PortinterfaceFactory.eINSTANCE.createClientServerInterface();
		autosarInterface.setShortName(csi_name);
		portInterfaces.getElements().add(autosarInterface);
		arxml_interfaces.put(csi, autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> senderReceiverInterfaceRule = batchTransformationRuleFactory.createRule(SenderReceiverInterfaceType.instance()).name("SenderReceiverInterfaceRule").action(match -> {
		Class sri = match.getUmlClass();
		String sri_name = sri.getName();
		SenderReceiverInterface autosarInterface = PortinterfaceFactory.eINSTANCE.createSenderReceiverInterface();
		autosarInterface.setShortName(sri_name);
		portInterfaces.getElements().add(autosarInterface);
		arxml_interfaces.put(sri, autosarInterface);
	}).build();
	
	protected BatchTransformationRule<?, ?> atomicSwComponentTypesRule = batchTransformationRuleFactory.createRule(AtomicSwComponentTypes.instance()).name("AtomicSwComponentTypesRule").action(match -> {
		Property aswct = match.getUmlProperty();
		String aswct_name = aswct.getName();
		AtomicSwComponentType autosarAswct = ComponentsFactory.eINSTANCE.createApplicationSwComponentType();
		autosarAswct.setShortName(aswct_name);
		atomicSwComponentTypes.getElements().add(autosarAswct);
		arxml_aswcts.put(aswct, autosarAswct);
	}).build();
	
	protected BatchTransformationRule<?, ?> compositionSwComponentTypesRule = batchTransformationRuleFactory.createRule(CompositionSwComponentTypes.instance()).name("CompositionSwComponentTypesRule").action(match -> {
		Class cswct = match.getUmlClass();
		String cswct_name = cswct.getName();
		CompositionSwComponentType autosarCswct = CompositionFactory.eINSTANCE.createCompositionSwComponentType();
		autosarCswct.setShortName(cswct_name);
		compositionSwComponentTypes.getElements().add(autosarCswct);
		arxml_cswcts.put(cswct, autosarCswct);
	}).build();
	
	protected BatchTransformationRule<?, ?> clientServerOperationRule = batchTransformationRuleFactory.createRule(CsiOperation.instance()).name("ClientServerOperationRule").action(match -> {
		Class csi = match.getUmlCsi();
		Operation cso = match.getUmlOperation();
		String cso_name = cso.getName();
		ClientServerInterface autosarCsi = (ClientServerInterface) arxml_interfaces.get(csi);
		ClientServerOperation autosarCSOperation = PortinterfaceFactory.eINSTANCE.createClientServerOperation();
		autosarCSOperation.setShortName(cso_name);
		autosarCsi.getOperations().add(autosarCSOperation);
		arxml_cso.put(cso, autosarCSOperation);
	}).build();
	
	protected BatchTransformationRule<?, ?> variableDataPrototypeRule = batchTransformationRuleFactory.createRule(SriVariableDataPrototype.instance()).name("VariableDataProtoypeRule").action(match -> {
		DataType apdt = match.getUmlAppPrimDataType();
		Class sri = match.getUmlSri();
		Property vdp = match.getUmlProperty();
		String vdp_name = vdp.getName();
		SenderReceiverInterface autosarSri = (SenderReceiverInterface) arxml_interfaces.get(sri);
		VariableDataPrototype autosarVariableDataProto = DataprototypesFactory.eINSTANCE.createVariableDataPrototype();
		autosarVariableDataProto.setShortName(vdp_name);
		ApplicationPrimitiveDataType autosarApdt = arxml_apdts.get(apdt);
		autosarVariableDataProto.setType(autosarApdt);
		autosarSri.getDataElements().add(autosarVariableDataProto);
		arxml_vdps.put(vdp, autosarVariableDataProto);
	}).build();
	
	protected BatchTransformationRule<?, ?> receivePortAswctRule = batchTransformationRuleFactory.createRule(ReceivePortAswct.instance()).name("RPortAswctRule").action(match -> {
		Property aswct = match.getUmlProperty();
		Port rPort = match.getUmlPort();
		String rpp_name = rPort.getName();
		AtomicSwComponentType autosarAswct = arxml_aswcts.get(aswct);
		RPortPrototype rpp = ComponentsFactory.eINSTANCE.createRPortPrototype();
		rpp.setShortName(rpp_name);
		autosarAswct.getPorts().add(rpp);
		arxml_rports.put(rPort, rpp);
	}).build();
	
	protected BatchTransformationRule<?, ?> providePortAswctRule = batchTransformationRuleFactory.createRule(ProvidePortAswct.instance()).name("PPortAswctRule").action(match -> {
		Property aswct = match.getUmlProperty();
		Port pPort = match.getUmlPort();
		String ppp_name = pPort.getName();
		AtomicSwComponentType autosarAswct = arxml_aswcts.get(aswct);
		PPortPrototype ppp = ComponentsFactory.eINSTANCE.createPPortPrototype();
		ppp.setShortName(ppp_name);
		autosarAswct.getPorts().add(ppp);
		arxml_pports.put(pPort, ppp);
	}).build();
	
	protected BatchTransformationRule<?, ?> receivePortCswctRule = batchTransformationRuleFactory.createRule(ReceivePortCswct.instance()).name("RPortCswctRule").action(match -> {
		Class cswct = match.getUmlClass();
		Port rPort = match.getUmlPort();
		String rpp_name = rPort.getName();
		CompositionSwComponentType autosarCswct = arxml_cswcts.get(cswct);
		RPortPrototype rpp = ComponentsFactory.eINSTANCE.createRPortPrototype();
		rpp.setShortName(rpp_name);
		autosarCswct.getPorts().add(rpp);
		arxml_rports.put(rPort, rpp);
	}).build();
	
	protected BatchTransformationRule<?, ?> providePortCswctRule = batchTransformationRuleFactory.createRule(ProvidePortCswct.instance()).name("PPortCswctRule").action(match -> {
		Class cswct = match.getUmlClass();
		Port pPort = match.getUmlPort();
		String ppp_name = pPort.getName();
		CompositionSwComponentType autosarCswct = arxml_cswcts.get(cswct);
		PPortPrototype ppp = ComponentsFactory.eINSTANCE.createPPortPrototype();
		ppp.setShortName(ppp_name);
		autosarCswct.getPorts().add(ppp);
		arxml_pports.put(pPort, ppp);
	}).build();
	
	protected BatchTransformationRule<?, ?> swComponentPrototypeRule = batchTransformationRuleFactory.createRule(SwComponentPrototypes.instance()).name("SwComponentTypeRule").action(match -> {
		Class cswct = match.getUmlClass();
		Property aswct = match.getUmlProperty();
		String scp_name = "scp_" + scpNum + "_" + aswct.getName();	
		CompositionSwComponentType autosarCswct = arxml_cswcts.get(cswct);
		SwComponentPrototype autosarScp = CompositionFactory.eINSTANCE.createSwComponentPrototype();
		autosarScp.setShortName(scp_name);
		autosarCswct.getComponents().add(autosarScp);
		scpNum++;
		arxml_scps.put(aswct, autosarScp);
	}).build();
	
	protected BatchTransformationRule<?, ?> assemblySwConnectorRule = batchTransformationRuleFactory.createRule(AssemblySwConnectors.instance()).name("ASwConnectorRule").action(match -> {
		InformationFlow flow = match.getUmlInfFlow();
		Property aswct_source = match.getUmlSourceProperty();
		Port aswct__source_rpp = match.getUmlSourcePort();
		Property aswct_target = match.getUmlTargetProperty();
		Port aswct_target_ppp = match.getUmlTargetPort();
		String aswconn_name = flow.getName();
		AtomicSwComponentType autosarAswct = arxml_aswcts.get(aswct_source);
		AssemblySwConnector autosarAswconn = CompositionFactory.eINSTANCE.createAssemblySwConnector();
		RPortPrototype rPort = arxml_rports.get(aswct__source_rpp);
		autosarAswconn.setShortName(aswconn_name);
		//TODO
		arxml_aswconns.put(flow, autosarAswconn);
	}).build();
	
	protected BatchTransformationRule<?, ?> rDelegationSwConnectorRule = batchTransformationRuleFactory.createRule(RDelegateSwConnectors.instance()).name("rDSwConnectorRule").action(match -> {
		InformationFlow flow = match.getUmlInfFlow();
		Class cswct = match.getUmlSourceClass();
		Port rSourcePort = match.getUmlSourcePort();
		Property aswct = match.getUmlTargetProperty();
		Port rTargetPort = match.getUmlTargetPort();
		String dswconn_name = flow.getName();
		CompositionSwComponentType autosarCswct = arxml_cswcts.get(cswct);
		DelegationSwConnector autosarDswconn = CompositionFactory.eINSTANCE.createDelegationSwConnector();
		RPortPrototype rPort = arxml_rports.get(rSourcePort);
		autosarDswconn.setShortName(dswconn_name);
		autosarDswconn.setOuterPort(rPort);
		autosarCswct.getConnectors().add(autosarDswconn);
		arxml_dswconns.put(flow, autosarDswconn);
	}).build();
	
	protected BatchTransformationRule<?, ?> pDelegationSwConnectorRule = batchTransformationRuleFactory.createRule(PDelegateSwConnectors.instance()).name("pDSwConnectorRule").action(match -> {
		InformationFlow flow = match.getUmlInfFlow();
		Property aswct = match.getUmlSourceProperty();
		Port pSourcePort = match.getUmlSourcePort();
		Class cswct = match.getUmlTargetClass();
		Port pTargetPort = match.getUmlTargetPort();
		String dswconn_name = flow.getName();
		CompositionSwComponentType autosarCswct = arxml_cswcts.get(cswct);
		DelegationSwConnector autosarDswconn = CompositionFactory.eINSTANCE.createDelegationSwConnector();
		PPortPrototype pPort = arxml_pports.get(pSourcePort);
		autosarDswconn.setShortName(dswconn_name);
		autosarDswconn.setOuterPort(pPort);
		autosarCswct.getConnectors().add(autosarDswconn);
		arxml_dswconns.put(flow, autosarDswconn);
	}).build();

	protected BatchTransformationRule<?, ?> rDswConnInstanceRefRule = batchTransformationRuleFactory.createRule(RDswConnInstanceRef.instance()).name("rDSwConnInstanceRefRule").action(match -> {
		InformationFlow flow = match.getUmlRDswConn();
		Property scp = match.getUmlScp();
		Port scpPort = match.getUmlScpRPort();
		DelegationSwConnector autosarDswconn = arxml_dswconns.get(flow);
		SwComponentPrototype autosarScp = arxml_scps.get(scp);
		RPortPrototype autosarPort = arxml_rports.get(scpPort);
		RPortInCompositionInstanceRef autosarInstanceRefRPort = InstancerefsFactory.eINSTANCE.createRPortInCompositionInstanceRef();
		autosarDswconn.setInnerPort(autosarInstanceRefRPort);
		autosarInstanceRefRPort.setContextComponent(autosarScp);
		autosarInstanceRefRPort.setTargetRPort(autosarPort);
	}).build();
	
	protected BatchTransformationRule<?, ?> pDswConnInstanceRefRule = batchTransformationRuleFactory.createRule(PDswConnInstanceRef.instance()).name("pDSwConnInstanceRefRule").action(match -> {
		InformationFlow flow = match.getUmlPDswConn();
		Property scp = match.getUmlScp();
		Port scpPort = match.getUmlScpPPort();
		DelegationSwConnector autosarDswconn = arxml_dswconns.get(flow);
		SwComponentPrototype autosarScp = arxml_scps.get(scp);
		PPortPrototype autosarPort = arxml_pports.get(scpPort);
		PPortInCompositionInstanceRef autosarInstanceRefPPort = InstancerefsFactory.eINSTANCE.createPPortInCompositionInstanceRef();
		autosarDswconn.setInnerPort(autosarInstanceRefPPort);
		autosarInstanceRefPPort.setContextComponent(autosarScp);
		autosarInstanceRefPPort.setTargetPPort(autosarPort);
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
		statements.fireAllCurrent(senderReceiverInterfaceRule);		
		statements.fireAllCurrent(atomicSwComponentTypesRule);
		statements.fireAllCurrent(compositionSwComponentTypesRule);
		statements.fireAllCurrent(clientServerOperationRule);
		statements.fireAllCurrent(variableDataPrototypeRule);
		statements.fireAllCurrent(receivePortAswctRule);
		statements.fireAllCurrent(providePortAswctRule);
		statements.fireAllCurrent(receivePortCswctRule);
		statements.fireAllCurrent(providePortCswctRule);
		statements.fireAllCurrent(swComponentPrototypeRule);
		statements.fireAllCurrent(assemblySwConnectorRule);
		statements.fireAllCurrent(rDelegationSwConnectorRule);
		statements.fireAllCurrent(pDelegationSwConnectorRule);
		statements.fireAllCurrent(rDswConnInstanceRefRule);
		statements.fireAllCurrent(pDswConnInstanceRefRule);
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


package hu.bme.mit.sysml2autosar.cli;

import java.io.IOException;

import org.artop.aal.common.resource.impl.AutosarResourceSetImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;

import autosar40.autosartoplevelstructure.AUTOSAR;
import autosar40.autosartoplevelstructure.AutosartoplevelstructureFactory;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ARPackage;
import autosar40.genericstructure.generaltemplateclasses.arpackage.ArpackageFactory;
import hu.bme.mit.sysml2autosar.transformation.BatchModelTransformation;

public class ApplicationStarter {
	
	private ResourceSet umlResourceSet;
	private final String umlFileUri = "C:/Users/KoczkaP/workspace-papyrus/Szakdolgozat/Szakdolgozat.uml";
	private ResourceSet autosarResourceSet;
	private final String autosarFileUri = "C:/Users/KoczkaP/Documents/Artop/workspace/Szakdolgozat/outputModel.arxml";
	private final ARPackage arRoot = ArpackageFactory.eINSTANCE.createARPackage(); 
	private final ARPackage applicationDataType = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage swComponents = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage portInterfaces = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage swComponentTypes = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage atomicSwComponentTypes = ArpackageFactory.eINSTANCE.createARPackage();
	private final ARPackage compositionSwComponentTypes = ArpackageFactory.eINSTANCE.createARPackage();
	
	/**
	 * Start the CLI Application.
	 * @param arguments
	 * @return
	 */
	public Integer start(final String[] arguments) {
            if(arguments.length == 2) {
                readPapyrusModel(umlFileUri);
                runTransform();
                createArxmlFileWithSave(autosarFileUri);
            }
            else {
            	throw new RuntimeException("One or both of the input models are bad");
            }
			return null;
    }
	
	/**
     * Run the transformation.
     * 
     * @return
     */
    private Integer runTransform() {

            BatchModelTransformation transformation = new BatchModelTransformation(umlResourceSet);

        return IApplication.EXIT_OK;
    }
	
    /**
     * Read the input Papyrus Model.
     * @param umlFileUri
     */
	private void readPapyrusModel(String umlFileUri) {
		umlResourceSet = new ResourceSetImpl();
		//UMLUtil.init(resourceSet);
		URI inputModelFile = URI.createFileURI(umlFileUri);
		Resource resource = umlResourceSet.getResource(inputModelFile, true);		
	}
	
	/**
	 * Create the output arxml file with the ARPackages.
	 * @param autosarFileUri
	 */
	private void createArxmlFileWithSave(String autosarFileUri) {
		autosarResourceSet = new AutosarResourceSetImpl();
		URI outputModelFile = URI.createFileURI(autosarFileUri);
		Resource resource = autosarResourceSet.createResource(outputModelFile);
		AUTOSAR autosar = AutosartoplevelstructureFactory.eINSTANCE.createAUTOSAR();
		resource.getContents().add(autosar);
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
		
		try{
		    resource.save(null);
		    java.lang.System.out.println("Created successfully");
		} catch (IOException e){
		    java.lang.System.out.print("Error while creating arxml file");
		}  
	}
}

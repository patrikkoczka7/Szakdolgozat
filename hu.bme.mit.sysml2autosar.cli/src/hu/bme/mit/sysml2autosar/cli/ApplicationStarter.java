package hu.bme.mit.sysml2autosar.cli;

import java.io.IOException;

import org.artop.aal.common.resource.impl.AutosarResourceSetImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import hu.bme.mit.sysml2autosar.transformation.BatchModelTransformation;

public class ApplicationStarter {
	
	private ResourceSet umlResourceSet;
	private Resource umlResource;
	private ResourceSet autosarResourceSet;
	private Resource autosarResource;
	
	/**
	 * Start the CLI Application.
	 * @param arguments
	 * @return
	 */
	public Integer start(final String[] arguments) {
            if(arguments.length == 2) {
                readPapyrusModel(arguments[0]);
                createArxmlFile(arguments[1]);
                runTransform();
                saveArxmlFile();
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

            BatchModelTransformation transformation = new BatchModelTransformation(umlResourceSet, autosarResource);
            transformation.execute();
            
        return IApplication.EXIT_OK;
    }
	
    /**
     * Read the input Papyrus Model.
     * @param umlFileUri
     */
	private void readPapyrusModel(String umlFileUri) {
		umlResourceSet = new ResourceSetImpl();
		//UMLUtil.init(umlResourceSet);
		UMLResourcesUtil.init(umlResourceSet);
		URI inputModelFile = URI.createFileURI(umlFileUri);
		umlResource = umlResourceSet.getResource(inputModelFile, true);		
	}
	
	/**
	 * Create the output arxml file with the ARPackages.
	 * @param autosarFileUri
	 */
	private void createArxmlFile(String autosarFileUri) {
		autosarResourceSet = new AutosarResourceSetImpl();
		URI outputModelFile = URI.createFileURI(autosarFileUri);
		autosarResource = autosarResourceSet.createResource(outputModelFile);
	}
	
	/**
	 * Save the output file.
	 * @param resource
	 */
	private void saveArxmlFile() {
		try{
		    autosarResource.save(null);
		    java.lang.System.out.println("Created successfully");
		} catch (IOException e){
		    java.lang.System.out.print("Error while creating arxml file");
		}  
	}
}

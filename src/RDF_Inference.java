
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;

public class RDF_Inference {
	public static void getAllInferences(Model model) {
		//Create a reasoner
		Reasoner reasoner = ReasonerRegistry.getRDFSReasoner();
		reasoner.setDerivationLogging(true);
		//Create inference model
		InfModel inf = ModelFactory.createInfModel(reasoner, model);
		//View the in-memory inferred RDF Model
		inf.write(System.out,"RDF/XML-ABBREV");
	}
}

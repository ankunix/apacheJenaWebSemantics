import org.apache.jena.rdf.model.Model;
public class Run {

	public static void main(String[] args) {

		//Add the statement one by one in your code to manually create the RDF model.
//		Model model = RDF_Validator.createUnivRDF();
		//Remote RDF file location
//		String URI = "http://ankush.tech/foaf.rdf";
  		//Local RDF file location
		String URI = "https://www.w3.org/2002/12/cal/ical";
  		//Read the model from a file
  		Model model = RDF_Validator.RDF_URI_Reader(URI);
  		//View the in-memory RDF Model
  		model.write(System.out,"RDF/XML-ABBREV");

 //Determining additional triples (for part 2 of the assignment)
  		//RDF_Inference.getAllInferences(model);
    }
}

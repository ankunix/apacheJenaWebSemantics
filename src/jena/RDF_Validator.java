package jena;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
public class RDF_Validator {
	static OntModel model = ModelFactory.createOntologyModel();

	public static Model RDF_URI_Reader(String URI)  {
		//Initialize input stream
		InputStream in = null;
		try { in = new URL(URI).openStream(); //Load Input Stream
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Initialize an in-memory Jena Ontoloogy Model Object
		// parses an InputStream assuming RDF in RDF/XML format
		model.read(in, null, "RDF/XML");
		return model;
	}

	public static Model createUnivRDF() {
		String u = "http://www.example.com/univ#";
		//A Person is a class, a Student is a subclass of Person, and a Professor is also a subclass of Person.
		OntClass Person = model.createClass( u+"Person" );
		OntClass Professor = model.createClass( u+"Professor" );
		OntClass Student = model.createClass( u+"Student" );
		OntClass Course = model.createClass( u+"Course" );
		//Assign sub-class
		Person.addSubClass( Professor );
		Person.addSubClass( Student );
		//Create knows property
		OntProperty knows = model.createOntProperty(u+"knows");
		//A Person 'knows' another Person
		knows.addDomain(Person);
		knows.addRange(Person);
		//Create advises property
		OntProperty advises = model.createOntProperty(u+"advises");
		//A Person 'knows' another Person
		advises.addDomain(Professor);
		advises.addRange(Student);
		//advises is a sub-property of knows, and it is used to describe the fact that a Professor advises a Student.
		knows.addSubProperty(advises);
		//Create teaches property
		OntProperty teaches = model.createOntProperty(u+"teaches");
		//teaches is a property, and it is used to describe the fact that a Professor teaches a Course.
		teaches.addDomain(Professor);
		teaches.addRange(Course);
		return model;
	}
}

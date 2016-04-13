package cs520.util;

import java.util.HashMap;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * According to Hibernate documentation, both Configuration and
 * Ejb3Configuration are deprecated and will be removed in Hibernate 5.
 * Hopefully by then SchemaExport can be initialized from persistence.xml
 * instead of hibernate.cfg.xml or hibernate.properties, and if so, we can
 * remove this class and run SchemaExport directly.
 */
@SuppressWarnings("deprecation")
public class Hbm2DdlCreate
{

	public static void main(String args[])
	{
		if (args.length > 2)
		{
			System.err.println("java Hbm2ddl 	<outputFile>");
			return;
		}

		System.out.print("Export Create SQL to " + args[0] + " ... ");

		Configuration cfg = (new Ejb3Configuration())
				.configure("gappPersistance", new HashMap<String, Object>())
				.getHibernateConfiguration();

		SchemaExport schemaExport = new SchemaExport(cfg);

		schemaExport.setOutputFile(args[0]).setDelimiter(";").setFormat(true)
				.setHaltOnError(true);

		// . output script to console (and file if outputFile is set): true
		// . export to database: false
		// . only drop the tables: false
		// . only create the tables: true
		schemaExport.execute(false, false, false, true);

		System.out.print("Export Drop SQL to " + args[1] + " ... ");

		schemaExport.setOutputFile(args[1]).setDelimiter(";").setFormat(true)
				.setHaltOnError(true);

		// . output script to console (and file if outputFile is set): true
		// . export to database: false
		// . only drop the tables: false
		// . only create the tables: true
		schemaExport.execute(false, false, true, false);

		System.out.println("Done.");
	}

}
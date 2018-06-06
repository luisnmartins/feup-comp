package parser;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Stack;
import table.*;

public class YAL{

    public static String filename;
    public static String module_name;
    private LinkedHashMap<String, SymbolTable> symbolTables;
    private Parser parser;
    public static Boolean optimized = false;

    YAL(Parser parser) {
        this.parser = parser;
        this.symbolTables = new LinkedHashMap<>();
        try {
            
            SimpleNode root = parser.Module();


            if(root != null) root.dump("");
            System.out.println("\n\n\n");

            if(!this.startSymbolTable(root)) {
                return;
            }
            ASTModule module = (ASTModule) root;
            
            if(module.children != null){
                module.print();
                module.setYAL2JVM();
            }
                

        } catch (ParseException e) {
            System.out.println("Parser: There was an error during the parse.");
            System.out.println(e.getMessage());
        } catch (TokenMgrError e) {
            System.out.println("Parser: There was an error.");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Parser xparser;

        if (args.length == 0) {
            System.out.println("Parser, reading the input...");
            System.out.println("If you want to use a file you should stop and run as: ");
            System.out.println("java -jar yal2jvm.jar [-o] <file_path.yal>");
            xparser = new Parser(System.in);
        } else if (args.length >= 1 && args.length < 3) {
            int file = 0;
            if (args[0].equals("-o")) {
                optimized = true;
                file = 1;
            }
            System.out.println("Parser: Reading the file " + args[file]);
            filename = args[file];
            

            try {

                xparser = new Parser(new java.io.FileInputStream(args[file]));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("Parser, The file " + args[file] + " was not found");
                return;

            }
        } else {
            System.out.println("Parser:  You must use one of the following:");
            System.out.println("         java parser < file");
            System.out.println("Or");
            System.out.println("         java parser file");
            return;
        }
        YAL yal = new YAL(xparser);
    }

    //start symbol table with root node
    public boolean startSymbolTable(SimpleNode root) {
        if (root != null) {
            try {
                return root.tableHandler(null).getKey();
            } catch(ParseException e) {
                e.getMessage();
                return false;
            }
        }else{
            return false;
        }
        
    }

}

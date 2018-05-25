import java.util.LinkedHashMap;
import java.util.Stack;

public class YAL{

    public static String filename;
    private LinkedHashMap<String, SymbolTable> symbolTables;
    private Parser parser;

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
            xparser = new Parser(System.in);
        } else if (args.length == 1) {
            System.out.println("Parser: Reading the file " + args[0]);
            filename = args[0];
            try {
                xparser = new Parser(new java.io.FileInputStream(args[0]));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("Parser, The file " + args[0] + " was not found");
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

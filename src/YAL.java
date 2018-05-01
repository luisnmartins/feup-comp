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
            module.print();
            module.setYAL2JVM();
                

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

    /*public void startJVM(SimpleNode root) {
        if (root != null) {
            if (root instanceof ASTModule) {
                Node[] rootChildren = root.jjtGetChildren();
                setRegistries(rootChildren);
                getJVMCode(root.name, rootChildren);
            }
        }
        return;
    }

    public void setRegistries(Node[] rootChildren) {
        int registry = 0;
        for (int i = 0; i < rootChildren.length; i++) {
            // if (rootChildren[i] instanceof ASTDeclaration) {
            //     ASTElement element = (ASTElement) rootChildren[i].jjtGetChild(0);
            //     Symbol symbol = symbolTables.get("Global").hasRegistry(element.name);
            //     if (symbol != null) {
            //         symbol.setRegistry(registry);
            //         registry++;
            //     }

            // } else
            if (rootChildren[i] instanceof ASTFunction) {
                ASTFunction function = (ASTFunction) rootChildren[i];
                String scopeName = function.name;

                if (function.jjtGetChild(0) instanceof ASTVarlist) {
                    Node param = function.jjtGetChild(0);

                    for (int j = 0; j < param.jjtGetNumChildren(); j++) {
                        ASTElement element = (ASTElement) param.jjtGetChild(j);
                        Symbol symbol = this.symbolTables.get(scopeName).hasRegistry(access.name);
                        if (symbol != null) {
                            symbol.setRegistry(registry);
                            registry++;
                        }
                    }
                }

                Node[] functionChildren = rootChildren[i].jjtGetChildren();
                for (int j = 0; j < functionChildren.length; j++) {
                    if (functionChildren[j] instanceof ASTAssign) {
                        ASTAccess access = (ASTAccess) functionChildren[i].jjtGetChild(0);
                        Symbol symbol = this.symbolTables.get(scopeName).hasRegistry(access.name);
                        if (symbol != null) {
                            symbol.setRegistry(registry);
                            registry++;
                        }
                    }
                }
            }

        }
    }

    public void getJVMCode(String module_name, Node[] rootChildren) {
        instructions = new Array();
        declarations = new Array();
        statics = new Array();
        functions = new Array();
        instructions.push(".class public " + module_name);
        instructions.push(".super java/lang/Object");

       
        

        int array_counter = 0;

        for (int i = 0; i < rootChildren.length; i++) {
            if (rootChildren[i] instanceof ASTDeclaration) {
                ASTElement element = (ASTElement) rootChildren[i].jjtGetChild(0);
                String dec = ".field static " + element.name;

                if (element.isArray)
                    dec += " [I ";
                else
                    dec += " I ";

                if (rootChildren[i].jjtGetNumChildren() > 1) {
                    if(element.isArray){
                        if (rootChildren[i].jjtGetChild(1) instanceof ASTDeclarationValue) {
                            ASTDeclarationValue declarationValue = (ASTDeclarationValue) rootChildren[i].jjtGetChild(1);
                            if(declarationValue.signal != null && declarationValue.value != null){

                            }
                            // if (global.isArray() && !global.isInitialized()) {
                            //     System.out.println("Array " + globalVariableName + " has not size specified");
                            //     return false;
                            // }

                        }else if (rootChildren[i].jjtGetChild(1) instanceof ASTArraySize) {
                            ASTArraySize arraySize = (ASTArraySize) rootChildren[i].jjtGetChild(1);
                            if(arraySize.isSize){
                                statics.push("bipush " + arraySize.sizeVar + ".size");
                            }else if(arraySize.sizeVar != null){
                                statics.push("bipush " + arraySize.sizeVar);
                            }else{
                                statics.push("bipush " + arraySize.size);
                            }

                            statics.push("newarray int");
                            statics.push("putstatic " + module_name + " " + array_counter + "/" + element.name + "[I");
                        }
                        array_counter++;
                    }else{
                        if (rootChildren[i].jjtGetChild(1) instanceof ASTDeclarationValue) {
                            ASTDeclarationValue declarationValue = (ASTDeclarationValue) rootChildren[i].jjtGetChild(1);
                            if (declarationValue.signal != null && declarationValue.value != null) {
                                dec += "= " + declarationValue.signal + declarationValue.value;
                            }else if(declarationValue.signal == null && declarationValue.value != null){
                                dec += "= " + declarationValue.value;
                            }

                        }else if (rootChildren[i].jjtGetChild(1) instanceof ASTArraySize) {
                            ASTArraySize arraySize = (ASTArraySize) rootChildren[i].jjtGetChild(1);
                            if(arraySize.isSize){
                                statics.push("bipush " + arraySize.sizeVar + ".size");
                            }else if(arraySize.sizeVar != null){
                                statics.push("bipush " + arraySize.sizeVar);
                            }else{
                                statics.push("bipush " + arraySize.size);
                            }

                            statics.push("newarray int");
                            statics.push("putstatic " + module_name + " " + array_counter + "/" + element.name + "[I");
                        }
                        array_counter++;
                    }   
                    /*if(rootChildren[i].jjtGetChild(1) instanceof ASTDeclarationValue && 
                        isArray && global == null){
                            isArray = false;
                    }
                    
                    if(rootChildren[i].jjtGetChild(1) instanceof ASTDeclarationValue && 
                        isArray && global == null)*/

                    
                /*}

                            

                declarations.push(dec);

            }

        }

        declarations.push(".method static public <clinit>()V");

        declarations.push(".limit stack " + array_counter);
        declarations.push(".limit locals 0");

        //

        statics.push("return");
        statics.push(".end_method");
    }

    // public void getJVMCode(Node[] rootChildren) {
    //     for (int i = 0; i < rootChildren.length; i++) {
    //         if (rootChildren[i] instanceof ASTFunction) {

    //             if (function.jjtGetChild(0) instanceof ASTVarlist) {
    //                 Node param = function.jjtGetChild(0);

    //                 for (int j = 0; j < param.jjtGetNumChildren(); j++) {
    //                     ASTElement element = (ASTElement) param.jjtGetChild(j);

    //                     functionScope.pushParameter(element.name, element.isArray, true);
    //                 }
    //             }
    //             if (function.returnValue != null) {
    //                 functionScope.setReturnParameter(function.returnValue, function.returnArray, false);
    //             }
    //         }
    //     }
    // }*/

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

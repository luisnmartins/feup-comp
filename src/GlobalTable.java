import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GlobalTable extends SymbolTable {

    private HashMap<String,FunctionTable> functions;
    private String moduleName;
    int loopCount = 0;
    int ifcount = 0;
    public GlobalTable(){
        super();
        functions = new HashMap<>();
    }

    public void addFunction(String functionName, FunctionTable newFunction) {
        functions.put(functionName, newFunction);
    }

    public void showAll() {
        this.print();
        for(Map.Entry<String, FunctionTable> entry : functions.entrySet()) {
            System.out.println("TABLE: "+entry.getKey());
            entry.getValue().print();
        }
    }

    public FunctionTable getFunction(String name) {
        return functions.get(name);
    }


    @Override
    public GlobalTable clone() throws CloneNotSupportedException{
        GlobalTable newTable = (GlobalTable)super.clone();
        newTable.functions = (HashMap)functions.clone();
        return newTable;

    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public HashMap<String,FunctionTable> getFunctions(){
        return functions;
    }

    public void incLoopCount() {
        loopCount++;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public void incIfCount() {
        ifcount++;
    }

    public int getIfCount() {
        return ifcount;
    }


}